package model;
import java.time.*;

public class Event {
    private String name;
   
    private LocalDateTime startingDate;
    private int durationHours;
    private String nameTeacher;
    private Auditorium[] auditorium;
    private LocalDateTime finishDate;

    



    

    public Event(String name, LocalDateTime startingDate, int durationHours, String nameTeacher, LocalDateTime finishDate) {
        this.name = name;
        this.startingDate = startingDate;
        this.durationHours = durationHours;
        this.nameTeacher = nameTeacher;
        this.auditorium = new Auditorium[8];
        this.finishDate = finishDate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartingDate(){
        return this.startingDate;
    }

    public int getDurationHours(){
        return this.durationHours;
    }

    public LocalDateTime getFinishDate(){
        return this.finishDate;
    }

   

    public String getNameTeacher() {
        return this.nameTeacher;
    }

    public void setNameTeacher(String nameTeacher) {
        this.nameTeacher = nameTeacher;
    }
    
    public void setAuditorium(Auditorium auditorium) {
    	boolean inserted = false;
		for(int i = 0; i<this.auditorium.length && !inserted; i++){
			if(this.auditorium[i] == null){
                this.auditorium[i] = auditorium;
                inserted = true;
			}
		}
    }

    public String auditoriumToString(){
        String msg = "";
        for (int i = 0; i < auditorium.length; i++) {
            if(auditorium[i] != null){
                if(!msg.contains(auditorium[i].getName())){
                    msg += "  " + auditorium[i].getName();
                }
                
            }
        }
        return msg;
    }

    public String toString(){
        String msg = "\n[NAME]: " + this.name + " - [INITIAL DATE]: " + this.startingDate  + " - [END DATE]: " + this.finishDate + " - [RESPONSIBLE TEACHER]: " + this.nameTeacher;
        msg += " - [AUDITORIUM]: " + auditoriumToString();
        return msg;
    }

    public Auditorium[] getAuditoriums(){
        return this.auditorium;
    }

    

    

  
    


}
