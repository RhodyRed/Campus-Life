
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.JFrame;


/**
 *  User interaction occurs here
 * 
 */
public class WelcomeScreen extends JFrame implements MouseListener  {
	

	private int x,y; //mouse clicked coordinates

	private String am_or_pm;
	
	public WelcomeScreen() {
		
		//Just testing to see how the Calendar class works
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		Date date = calendar.getTime();
	    int month = calendar.get(Calendar.MONTH) + 1;
	    int year = calendar.get(Calendar.YEAR);
	    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
	    int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
	    int hour = calendar.get(Calendar.HOUR);
	    int minutes = calendar.get(Calendar.MINUTE);
	    int AMPM = calendar.get(Calendar.AM_PM);
	    
	    if(AMPM == 0)
	    	am_or_pm = "AM";
	    else
	    	am_or_pm = "PM";
	   
	    String formattedTime = (hour+":"+minutes + " "+ am_or_pm);
	    System.out.println("Current time is " + formattedTime);

		
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

	
	public void mouseReleased(MouseEvent e) {
		
		
	}
	
	

}
