package ui;
import java.util.*;
import model.*;

public class Main {
	private Scanner scs;
	private Scanner sci;
	private University univ;
	
	public static void main(String args[]) {
		Main main = new Main();
		main.menu();
		
	}
	
	public Main() {
		scs = new Scanner(System.in);
		sci = new Scanner(System.in);
		univ = new University("Icesi");
		
	}
	
	public void menu() {
		int opc = 0;
		while (opc!=10) {
			System.out.println("\nSelect the option:");
			System.out.println("1) Add auditorium 				2) Add event				3) Show auditoriums");
			System.out.println("4) Add another auditorium for an event  	5) Report defective chairs 		6) Calculate percentage of defective chairs");
			System.out.println("7) Show events ");
			System.out.println("10) Exit");
			opc = sci.nextInt();
			
			switch (opc) {
			case 1: 
				System.out.println(addAuditorium());
				break;
			case 2:
				System.out.println(addEvent()); 
		
				break;
			case 3:
				System.out.print("Enter the name of the auditorium to print: "); String audName = scs.nextLine();
				System.out.println(univ.showAudi(audName));
				break;
			
			case 4:
				System.out.print("Enter the name of the event that you want to add another auditorium: "); String eventName = scs.nextLine();
				System.out.print("Enter the name of the auditorium that you want to add to this event: "); String audName1 = scs.nextLine();
				System.out.println(univ.addAuditoriumTo(eventName, audName1));
				break;
			case 5:
				System.out.print("Enter the name of the auditorium that you want to report a defective chair: "); String audName2 = scs.nextLine();
				System.out.print("Enter the row of the chair: "); String row = scs.nextLine().toUpperCase(); char prow = row.charAt(0);
				System.out.print("Enter the number of the chair: "); int num = sci.nextInt();
				System.out.print("Enter the description of the defect: "); String description = scs.nextLine();
				System.out.println(univ.reportDefectiveChair(audName2, prow, num, description));
				break;
			case 6:
				System.out.print("Enter the name of the auditorium that you want to know the percentage of defective chairs: "); String aName = scs.nextLine();
				System.out.println(univ.calculateDefectivePercentage(aName));
				break;
			case 7:
				System.out.println(univ.showEvents());
				break;
			
			case 10:
				System.out.println("\nGoodbye!");
				break;
			default:
				System.out.println("Enter a valid option");
				break;
			
 			}
		}
	}
	
	public String addEvent() {
		String msg = "";
		System.out.print("Enter the name of the event: "); String name = scs.nextLine();
		System.out.print("Enter the date(yyyy-mm-dd): "); String date = scs.nextLine();
		System.out.print("Enter the initial hour(HH:MM): "); String inHour = scs.nextLine();
		System.out.print("Enter the duration hours: "); String durationHours = scs.nextLine();
		System.out.print("Enter the name of the responsible teacher: "); String nameTeacher = scs.nextLine();
		System.out.print("Enter the name of the auditorium: "); String audName = scs.nextLine();
		
		msg = univ.addEvent(name, date, inHour, durationHours, nameTeacher, audName);
		return msg;

	}

	public String addAuditorium(){
		String msg = "";
		System.out.print("Enter the name of the auditorium: "); String audName = scs.nextLine();
		int numRows = (int)(Math.random()*(3-10)+10);
		int rows[] = new int[numRows];
		System.out.println("number of rows= " + numRows);
		char character = 'A';
		for (int i = 0; i <rows.length ; i++) {
			System.out.print("Enter the number of chairs in row " + character + ": "); rows[i] = sci.nextInt();
			character++;
		}

		
		msg += univ.addAuditorium(audName, rows );
		
		return msg;
	}

}
