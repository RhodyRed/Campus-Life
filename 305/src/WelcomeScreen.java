
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

import javax.swing.JFrame;


/**
 *  User interaction occurs here
 * 
 */
public class WelcomeScreen extends JFrame implements MouseListener  {
	

	private int x,y; //mouse clicked coordinates
	Scanner keyboard = new Scanner(System.in);
	SimpleDateFormat formatter = new SimpleDateFormat("M/d/yyyy");
	
	
	public WelcomeScreen() {
		
		addMouseListener(this);
		
		//Just testing to see how the Calendar class works
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		Date d = calendar.getTime();
		
		/**
	    int month = calendar.get(Calendar.MONTH) + 1;
	    int year = calendar.get(Calendar.YEAR);
	    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
	    int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
	    int hour = calendar.get(Calendar.HOUR);
	    int minutes = calendar.get(Calendar.MINUTE);
	    **/

	    SimpleDateFormat df = new SimpleDateFormat("K:mm a");
	    String time = df.format(d);
	    String date = formatter.format(d);
	    
	    System.out.println("Current date is " + date);
	    System.out.println("Current time is " + time);

		
	}




	public void paint(Graphics p) 
	{
		
		
		
	}

	
	

	/**
	 * Not sure if MouseEvents are needed if we're using JButtons??
	 */
	public void mouseClicked(MouseEvent e) {
		
		
	}


	public void mouseEntered(MouseEvent e) {
		
		
	}

	
	public void mouseExited(MouseEvent e) {
		
		
	}

	
	/**
	 * Here we can call the methods based on what the user clicks on
	 */
	
	public void mousePressed(MouseEvent e) {
		x =e.getX();
		y =e.getY();
		
		if(x <= 100 && y <= 100)
		{
			createEvent();

			
		}
		
		/**
		 * if(create event button is clicked){
		 * 
		 * Prompt for details:  (name of event, date, time, location, materials, ask if they would
		 * like to repeat the event every week)
		 * 
		 * store the details into variables 
		 * eventName = ...
		 * date = ... (month,day,year)
		 * time = ... (hour,minute, am or pm)
		 * location = ...
		 * materials = ...
		 * 
		 * repeat = ...will ask which days to repeat and store in an int array?
		 * 
		 * Check if there are any events conflicting with the date/time the user inputed
		 *
		 * if there is a conflicting issue give error message
		 * 
		 * 
		 * 
		 * Event newEvent = new Event(eventName,month,day,year,hour,minutes, amOrpm,location,materials,repeat);
		 * 
		 * 
		*/
		
		/**
		 * if(day/week/month view tab is clicked)
		 * switch to that view
		 */
		
		/**
		 * if an event is clicked, bring up it's details and 
		 * a delete event button
		 */
		
	
		
	}

	




	private void createEvent() {
		/**
		 * Creating an event
		 */
		
		System.out.print("Name: ");
		String name = keyboard.next();
		
		System.out.print("Month: ");
		int m = keyboard.nextInt();
		System.out.print("Day: ");
		int d = keyboard.nextInt();
		System.out.print("Year: ");
		int y = keyboard.nextInt();
		
		
		System.out.print("Hour: ");
		int h = keyboard.nextInt();
		System.out.print("Min: ");
		int min = keyboard.nextInt();
		
		System.out.print("AM or PM: ");
		int ampm = keyboard.nextInt();
		
		System.out.print("Materials: ");
		String materials = keyboard.next();
		
		System.out.print("Location: ");
		String loc = keyboard.next();

		
		int [] r = new int[7];
		
		System.out.println("Repeat days? Y for yes ");
		String repeat = keyboard.next();

		
		int i = 0;
		while (repeat.equals("Y"))
		{
			System.out.println("What Day?");
			int rDay = keyboard.nextInt();
			if (rDay == 0 || rDay == 1|| rDay == 2||rDay ==3 ||rDay ==4 || rDay==5 || rDay ==6 )
			{
				r[i] = rDay;
				i++;
				System.out.print("Add another repeat day?");
				repeat = keyboard.next();
				
			}
			else
			{
				System.out.println("Invalid day:");
				
			}
			
		}
		
		Event newEvent = new Event(name,m,d,y,h,min,ampm,materials,loc,r);
		//Then add it to the collection (haven't created it yet)
		
	}




	public void mouseReleased(MouseEvent e) {
		
		
	}
	
	

}
