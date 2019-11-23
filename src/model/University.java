package model;
import java.util.ArrayList;
import java.time.*;

public class University {
	private String name;
	
	private Auditorium[] auditorium;
	private ArrayList<Event> events;
	
	public University(String name) {
		this.name = name;
		auditorium = new Auditorium[8];
		
		this.events = new ArrayList<Event>();
	}

	public String showAudi(String audName){
		String msg = "";
		Auditorium temp = searchAuditorium(audName);
		if(temp != null){
			msg = temp.showAudi();
		}
		else{
			msg = "\nThis auditorium doesn't exists";
		}
		return msg;
	}

	
	
	public Auditorium searchAuditorium(String name) {
		Auditorium temp = null;
		boolean found = false;
		for (int i = 0; i<auditorium.length && !found; i++) {
			if(auditorium[i] != null) {
				if(auditorium[i].getName().equalsIgnoreCase(name)) {
					temp = auditorium[i];
					found = true;
				}
			}
		}
		return temp;
		
	}
	

	public Event searchEvent(String eventName){
		Event temp = null;
		boolean found = false;
		for(int i = 0; i < events.size() && !found; i++){
			if(events.get(i).getName().equalsIgnoreCase(eventName)){
				temp = events.get(i);
				found = true;
			}
		}
		return temp;
	}
	
	

	public String showEvents(){
		String msg = "";
		
		for(int i = 0; i<events.size(); i++){
			
			
				msg += events.get(i).toString();
			
		}
		return msg;

	}

	

	public String addAuditorium(String name, int[] rows){
		String msg = "";
		boolean created = false;
		for (int i = 0; i < auditorium.length && !created; i++) {
			if(auditorium[i]==null){
				if(searchAuditorium(name)==null){
					auditorium[i] = new Auditorium(name, rows);
					created = true;
					msg += "\nAuditorium added";
				}
			}
		}
		return msg;
	}



	

	

	public String addEvent(String name, String date, String inHour, String durationHours, String nameTeacher, String audName){
		String msg = "";
		LocalDate date1 = LocalDate.parse(date);
		LocalTime timeIn = LocalTime.parse(inHour);
		LocalDateTime initialDate = LocalDateTime.of(date1, timeIn);
		int durationHours1 = Integer.parseInt(durationHours);
		LocalDateTime finishDate = initialDate.plusHours(durationHours1);
		if(searchAuditorium(audName)!= null){
		if(searchAuditorium(audName).getEvents().size()>0 ){
			
			for (Event temp : searchAuditorium(audName).getEvents() ) {
				
				if(temp.getStartingDate().isEqual(initialDate) || (initialDate.isBefore(temp.getFinishDate()) && finishDate.isAfter(temp.getStartingDate() ) ) ) {
					msg += "\nThis event is coinciding with the schedule of another";
				}

			}
		}
	}

		if(initialDate.isBefore(LocalDateTime.now())){
			msg += "\nEvent's date can´t be before the current date";
		}

		if(durationHours1 >12 || durationHours1<2){
			msg += "\nThe event must last at least 2 hours and less than 12";
		}

		if(initialDate.getHour()<7 || initialDate.getHour()>20){
			msg+= "\nThe event must begin after 7:00 am and before 20:00 pm";
		}


		if(searchAuditorium(audName)==null){
			msg+= "\nThis auditorium doesn´t exists.";
		}

		if(msg.equalsIgnoreCase("")){
			Event mirror = new Event(name, initialDate, durationHours1, nameTeacher, finishDate);
			mirror.setAuditorium(searchAuditorium(audName));
			
			events.add(mirror);
			searchAuditorium(audName).setEvent(mirror);
			msg += "\nEvent created.";
		}
		
		
		
		
		return msg;

	} 

	

	public String reportDefectiveChair(String audName, char prow, int num, String description){
		String msg = "";
		Auditorium temp = searchAuditorium(audName);
		if(temp != null){
			msg = temp.reportDefectiveChair(prow, num, description);

		}
		else{
			msg = "\nThis auditorium doesn´t exists";
		}
		return msg;
	}

	public String calculateDefectivePercentage(String name){
		String msg = "";
		Auditorium temp = searchAuditorium(name);
		if(temp != null){
			msg = "\nThe percentage of defective chairs is " + temp.calculateDefectivePercentage() + "%";
		}
		else{
			msg = "\nThis auditorium doesn't exists";
		}
		return msg;
	}

	
	



	

}
