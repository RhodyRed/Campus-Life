
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
public class WelcomeScreen extends JFrame implements MouseListener,TimerListener  {
	
	protected EventCollection collection;
	private int x,y; //mouse clicked coordinates
	private String time;
	private String date;
	
	Scanner keyboard = new Scanner(System.in);
	SimpleDateFormat formatter = new SimpleDateFormat("M/d/yyyy");
	
	
	
	public WelcomeScreen() {
		
		addMouseListener(this);
		
		//Just testing to see how the Calendar class works
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		Date d = calendar.getTime();
	    SimpleDateFormat df = new SimpleDateFormat("K:mm a");
	    time = df.format(d);
	    date = formatter.format(d);
	    System.out.println("Current date is " + date);
	    System.out.println("Current time is " + time);
	    
	    //Collection is created
	    collection = new ArrayEventCollection();
	    Repeat repeating = new Repeat(collection,time,date);


	    

		
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
		
		//If you click the upper left of the screen
		//It creates an event
		if(x <= 100 && y <= 100)
		{
			createEvent();

			
		}
		
		//Click bottom left of screen to see the events in collection
		if(x<=100 && y>=300)
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
		String ampm = keyboard.next(); 
		
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
		collection.add(newEvent);
		
		
	}




	public void mouseReleased(MouseEvent e) {
		
		
	}

	
	

}
