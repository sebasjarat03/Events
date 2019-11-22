package model;
import java.util.ArrayList;
import java.time.*;

public class Auditorium {
    public final String AVAILABLE = "available";
    public final String BUSY = "busy";
    private String name;
    private String status;
    private ArrayList<Event> events;
    private Chair chairs[][];
    private int[] audRows;
    

    public Auditorium(String name, int[] rows){
        this.name = name;
        this.chairs = new Chair[rows.length][maxNumChairs(rows)];
        this.status = AVAILABLE;
        this.events = new ArrayList <Event>();
        this.audRows = rows;

        char letra = 'A';
		for(int i = 0; i < rows.length; i++) {
			int numSilla = 1;
			for(int j = 0; j < rows[i]; j++) {
				chairs[i][j] = new Chair(letra, numSilla); 
				numSilla++;
			}
			letra++;
        }
        
       

    }

    public String showAudi(){
        String msg = "\nThis is the way your auditorium looks: \n";
		for(int i = 0; i < audRows.length; i++){
			for(int j = 0; j < audRows[i]; j++) {
				msg += "[" + chairs[i][j].getRow() + chairs[i][j].getNumChairs() + "]";
			}
			msg+="\n";
        }
        return msg;
    }

    public int maxNumChairs(int[] rows){
        int num = -1;
		for(int i = 0; i < rows.length; i++) {
			if(rows[i] > num) {num = rows[i];}
        }
        return num;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setEvent(Event event){
         events.add(event);
    }
    
    public String getName() {
    	return name;
    }

    public String getStatus(){
        return this.status;
    }

    public ArrayList <Event> getEvents(){
        return events;
    }

    public String reportDefectiveChair(char prow, int num, String description) {
		String msg = "We're sorry '" + prow + "' is not a valid row";
		num--;
		int newrow = -1;
		
		char letter = 'A';
		char[] letters = new char['Z'];
		for(int i = 0; i < letters.length; i++) {
			letters[i] = letter;
			letter++;
		}
		for(int i = 0; i < letters.length; i++) {
			if(prow == letters[i]) { newrow = i;}
		}
		
		if(newrow < 0 || newrow > chairs.length) { return msg;}
		if(num < 0 || num > chairs[0].length-1) { return "We're sorry '" + (num + 1) + "' is not a valid chair number";}
			
		if(chairs[newrow][num] != null) {
			chairs[newrow][num].setDescription(description);
			chairs[newrow][num].setState(Chair.DEFECTIVE);
			msg = "Defect reported successfully";
		}else {
			msg = "The chair that you are trying to report doesn't exists.";
		}
		
		return msg;
    }
    
    public double calculateDefectivePercentage() {
		int chairsTotal = 0;
		for(int i = 0; i < chairs.length; i++){
			for(int j = 0; j < chairs[0].length; j++) {
				if(chairs[i][j] != null) {chairsTotal++;}
			}
		}
		
		int defectiveChairs = 0;
		for(int i = 0; i < chairs.length; i++){
			for(int j = 0; j < chairs[0].length; j++) {
				if(chairs[i][j] != null && (chairs[i][j].getState().equals(Chair.DEFECTIVE))) {
					defectiveChairs++;
				}
			}
		}
		
		double percentage = (defectiveChairs*100)/chairsTotal;
		
		return percentage;
	}

    

    

}
