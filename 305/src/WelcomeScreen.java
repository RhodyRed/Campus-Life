
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.TimeZone;

import javax.swing.JFrame;


/**
 *  User interaction occurs here
 * 
 */
public class WelcomeScreen extends JFrame implements MouseListener  {
	
	protected EventCollection collection;
	private int x,y; //mouse clicked coordinates
	private String time; //current time
	private String date; //current date
	private Date start;//event start date+time
	private Date end; //event end date+time
	
	Scanner keyboard = new Scanner(System.in);
	SimpleDateFormat formatter = new SimpleDateFormat("M/d/yyyy");
	
	
	
	public WelcomeScreen() {
		
		addMouseListener(this);
		
		//This grabs current date+time
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		Date d = calendar.getTime();
	    SimpleDateFormat df = new SimpleDateFormat("K:mm a");
	    time = df.format(d);
	    date = formatter.format(d);
	    System.out.println("Current date is " + date);
	    System.out.println("Current time is " + time);
	    
	    //Collection is created
	    collection = new ArrayEventCollection();
	    Repeat repeating = new Repeat(collection);


	    

		
	}




	public void paint(Graphics p) 
	{
		
		
		p.drawString("Create Event", 50, 50);	//Test "buttons"
		p.drawString("Display the collection", 50, 350);	
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
		
		//If you click the upper left of the screen
		//It creates an event
		if(x <= 100 && y <= 100)
		{
			createEvent();

			
		}
		
		//Click bottom left of screen to see the events in collection
		if(x<=200 && y>=300)
		{
			collection.display();
		}
		
	
		
	}

	




	private void createEvent() {
		
		
		
		
		/**
		 * Creating an event
		 */
		
		System.out.print("Name: ");
		String name = keyboard.next();
		
		System.out.print("Enter Start Date in MM/DD/YYYY format: "); //MUST BE FORMATTED PROPERLY ex. 10/22/2015
		String sDate = keyboard.next();
		
		System.out.print("Enter Start Time in H:MM format: "); //ex. 1:30
		String sTime = keyboard.next();
		
		System.out.print("AM OR PM: ");  //type AM or PM
		String sAM_PM = keyboard.next();
		
		System.out.print("Enter End Date in MM/DD/YYYY format: ");
		String eDate = keyboard.next();
		
		System.out.print("Enter end Time in H:MM (AM or PM) format: ");
		String eTime = keyboard.next();
		
		System.out.print("AM OR PM: ");
		String eAM_PM = keyboard.next();
		
		String startDate = sDate+" "+sTime+ " "+sAM_PM; //combines the date and time into a single string
		String endDate =  eDate+" "+eTime+ " "+eAM_PM;
		

        try {
			start = new SimpleDateFormat("MM/dd/yyy K:mm a").parse(startDate);	//Formats the strings
	        end = new SimpleDateFormat("MM/dd/yyyy K:mm a").parse(endDate);
	        
            if (start.compareTo(end) >= 0) { 		//Start is after end, therefore invalid
            	while(start.compareTo(end) >= 0)	//Keeps asking for end date until valid
            	{
            		System.out.println("End date must be after start date");
            		
            		System.out.print("Enter End Date in MM/DD/YYYY format: ");
            		String eDate2 = keyboard.next();
            		
            		System.out.print("Enter end Time in H:MM format: ");
            		String eTime2 = keyboard.next();
            		
            		System.out.print("AM OR PM: ");
            		String eAM_PM2 = keyboard.next();
            		
            		String endDate2 =  eDate2+" "+eTime2 + " "+eAM_PM2;
            		end = new SimpleDateFormat("MM/dd/yyyy K:mm a").parse(endDate2);
            	}	

            } 
	        
		} catch (ParseException e) {

			e.printStackTrace();
		}
        
        
		
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
		

        
		
		Event newEvent = new Event(name, start,end,materials,loc,r);
		collection.add(newEvent);
		
		
	}




	public void mouseReleased(MouseEvent e) {
		
		
	}
	


	
	

}
