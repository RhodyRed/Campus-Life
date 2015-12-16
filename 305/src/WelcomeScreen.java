
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
 * 	WORK IN PROGRESS
 *  The Welcome Screen acts as a "Main Screen" in which the user
 *  can see and interact with the program. Events and
 *  their properties are created in this class
 * 
 */
public class WelcomeScreen extends JFrame implements MouseListener  {
	
	protected EventCollection collection; //the collection for events
	private int x,y; //mouse clicked coordinates
	private String time; //current time
	private String date; //current date
	private Date d; 
	
	private Date start;//event start date+time
	private Date end; //event end date+time

	Scanner keyboard = new Scanner(System.in);	
	SimpleDateFormat formatter = new SimpleDateFormat("M/d/yyyy");
	
	//TEST EVENTS
	private Date testStart1;
	private Date testEndStart1;
	private Date testEndStart2;
	private Date testStart2;

	
	
	/**
	 * Constructor
	 */
	public WelcomeScreen() {
		
		addMouseListener(this);
		
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());	//This grabs current date+time
		d = calendar.getTime();
		
	    SimpleDateFormat df = new SimpleDateFormat("H:mm a"); 				//Format of the time
	    time = df.format(d);
	    date = formatter.format(d);
	    
	    
	    System.out.println("Current date is " + date); 						//Print the date and time
	    System.out.println("Current time is " + time);
	    System.out.println("------------\n");
	    
	    collection = new ArrayEventCollection();				//Collection is created
	    
	    /*
	     * I MADE 2 TEST EVENTS HERE
	     */
	    
	    
	    String testDate1= "10/22/2013 1:30 PM";			//Test events start & end dates
	    String testEndDate1 = "12/6/2015 9:05 PM";
	    String testDate2= "9/12/2013 3:30 PM";
	    String testEndDate2 = "12/6/2015 7:48 PM";
	    
		
		try {
			testStart1 = new SimpleDateFormat("MM/dd/yyy K:mm a").parse(testDate1);			//Formats the strings
			testEndStart1 = new SimpleDateFormat("MM/dd/yyyy K:mm a").parse(testEndDate1);
			testStart2 = new SimpleDateFormat("MM/dd/yyy K:mm a").parse(testDate2);			//Formats the strings
			testEndStart2 = new SimpleDateFormat("MM/dd/yyyy K:mm a").parse(testEndDate2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
        int [] testR1 = {1,4}; 	//Test events repeat days
        int [] testR2 = {};
        
        
	    Event testEvent1 = new Event("Event 1", testStart1,testEndStart1,"","",testR1); 	//Create the test events
	    Event testEvent2 = new Event("Event 2", testStart2,testEndStart2,"","",testR2);
	    
	    
	    collection.add(testEvent1);				//Add test events to collection
	    collection.add(testEvent2);
	    

	    Repeat repeating = new Repeat(collection); //Start checking for repeats
	    
	    




		
	}




	public void paint(Graphics p) 
	{
		
		p.drawString("Create Event", 50, 50);					//Test "buttons"
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
			collection.display(); 	//Display the collection
		}
		
		
	
		
	}

	



	/**
	 * Inside this method, input is taken in by the user and 
	 * creates an event with those values. It then adds it into 
	 * the collection.
	 */
	private void createEvent() {
		
		
		
		

		
		System.out.print("Name: ");			//Prompt for name of the event
		String name = keyboard.next();		//Get the name
		
		
		
		System.out.print("Enter Start Date in MM/DD/YYYY format: ");	//Prompt for start date			
																		//MUST BE FORMATTED PROPERLY ex. 10/22/2015
		
		String sDate = keyboard.next(); 	//Get date
		
		
		
		System.out.print("Enter Start Time in H:MM format: "); 		//Prompt for event start time
																	//ex. 1:30
		
		String sTime = keyboard.next();	//Get time
		
		
		System.out.print("AM OR PM: ");  //Prompt for AM or PM
		String sAM_PM = keyboard.next(); //Get AM or PM
		
		System.out.print("Enter End Date in MM/DD/YYYY format: "); //Prompt for end date
		String eDate = keyboard.next(); //Get end date
		
		System.out.print("Enter end Time in H:MM (AM or PM) format: "); //Prompt for end time
		String eTime = keyboard.next(); //Get end time
		
		System.out.print("AM OR PM: ");	//Prompt for AM or PM for end time
		String eAM_PM = keyboard.next();	//Get AM or PM
		
		
		String startDate = sDate+" "+sTime+ " "+sAM_PM; //Combines the date and time into a single string
		String endDate =  eDate+" "+eTime+ " "+eAM_PM;
		

        try {
			start = new SimpleDateFormat("MM/dd/yyy K:mm a").parse(startDate);	//Formats the strings
	        end = new SimpleDateFormat("MM/dd/yyyy K:mm a").parse(endDate);
	        
            if (start.compareTo(end) >= 0) { 		//Start is after end, therefore invalid
            	while(start.compareTo(end) >= 0)	//Keeps asking for end date until valid
            	{
            		System.out.println("End date must be after start date");	//Invalid date was entered
            		
            		System.out.print("Enter End Date in MM/DD/YYYY format: ");	//Re-prompt for event details
            		String eDate2 = keyboard.next();
            		
            		System.out.print("Enter end Time in H:MM format: ");
            		String eTime2 = keyboard.next();
            		
            		System.out.print("AM OR PM: ");
            		String eAM_PM2 = keyboard.next();
            		
            		String endDate2 =  eDate2+" "+eTime2 + " "+eAM_PM2;	//Combine strings
            		end = new SimpleDateFormat("MM/dd/yyyy K:mm a").parse(endDate2); //Format
            	}	

            } 
	        
            
		} catch (ParseException e) {	//Catch exception

			e.printStackTrace();
		}
        
        
		
		System.out.print("Materials: ");	//Prompt for materials
		String materials = keyboard.next(); //Get materials
		
		System.out.print("Location: ");		//Prompt for location
		String loc = keyboard.next();		//Get location
	
		

		
		int [] r = new int[7];	//Array to hold repeat days
		
		System.out.println("Repeat days? Y for yes ");	//Prompt for repeat days
		String repeat = keyboard.next();	//Get Y or N


		int i = 0; //Counter
		
		while (repeat.equals("Y"))	//While the answer from user is Y
		{
			System.out.println("What Day?"); //Prompt for the day
			
			int rDay = keyboard.nextInt(); //Get the day
			
			if (rDay == 0 || rDay == 1|| rDay == 2||rDay ==3 ||rDay ==4 || rDay==5 || rDay ==6 )
			{
				r[i] = rDay; //Assign that day into the array
				i++;
				System.out.print("Add another repeat day?");	//Ask if there are more repeat days
				repeat = keyboard.next();		//Y or N
				
			}
			else
			{
				System.out.println("Invalid day:");	//If the repeat day is <0 or >6
				
			}
			
		}
		

        
		
		Event newEvent = new Event(name, start,end,materials,loc,r);	//Create the event
		collection.add(newEvent);	//Add it to the collection
		
		
	}




	public void mouseReleased(MouseEvent e) {
		
		
	}
	


	
	

}
