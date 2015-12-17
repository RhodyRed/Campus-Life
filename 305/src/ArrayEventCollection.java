import java.awt.Graphics;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * ArrayEventCollection is our datastructure to hold the events.
 *
 */
public class ArrayEventCollection implements EventCollection
{
	
	private final int SIZE = 100; //Default size
	private Event [] events;		//Array of events
	private int size;				//The current size
	private int selected;			//The selected event
	private Calendar calendar;		//The calendar
	
	/**
	 * Constructor
	 */
	public ArrayEventCollection()
	{
		events = new Event[SIZE];	//Instantiate the array 
		
		size = 0;		//Current size
		selected = -1;	//Nothing selected
		
				
	}
	
	/**
	 *  Changes the selected event
	 */
	public void changeSelection(int newSelection)
	{
		selected = newSelection;	//Change the selected to new selected
	}
	
	/**
	 * Adds an event
	 */
	public void add(Event someEvent) {
		if(selected == events.length)	//If the array is full
		{
			Event[] temp = new Event[events.length*2];	//Create a temp array with 2x the size
			
			for(int i = 0; i<events.length; i++)	
			{
				temp[i] = events[i]; //Copy over the values in the array to temp
				events = temp;		//Copy back the values in temp to events
			}
		}
		events[size] = someEvent;	//Add the event to array
		changeSelection(size++);	//increase current size counter
		
		
	}

	/**
	 * Removes an event
	 */

	public void remove() 
	{
			for (int i = selected ; i < size-1; i++)
				events[i] = events[i+1];		//remove the selected
			
			size--;					//decrease current size counter
			changeSelection(-1);	//De-select
		
	}


	/**
	 * Resets to the beginning of the collection
	 */
	public void reset() {

		changeSelection(0);	
	}


	public void reset(Event someEvent) {
		
		int i = 0;							
		changeSelection(-1);	//De-select
		
		while (selected == -1 && i < size) 
		{
			if (events[i] == someEvent)	
				changeSelection(i); 	//Change selected
			i++;
		}
		

		
	}

	/**
	 * Checks if the collection has another event
	 */

	public boolean hasNext() {

		return (size > 0) && (selected >= 0) && (selected < size);	//Check for next event
	}
	
	
	/**
	 * This method compares the current date and time to the
	 * end date and times within the events in the collection
	 */
	public void compareDates(Date d)
	{

		calendar = Calendar.getInstance(TimeZone.getDefault()); //Create a calendar instance

		for (int i = 0; i<size; i++) //Go through the collection
			
			if (d.equals(events[i].getEndDate())) //If the current date+time is equal to the end date
												  //of one of the events
			{
				System.out.println(events[i].getName() + " has ended"); 
				if (events[i].getRepeatDays() == true) //If the event is repeating
				{
					calendar.setTime(events[i].getStartDate()); //Move the event start date to the next week
					calendar.add(Calendar.DATE,7);	
					Date nextWeekStart = calendar.getTime();
					events[i].setStartDate(nextWeekStart);
					
					calendar.setTime(events[i].getEndDate());	//Move the event end date to the next week
					calendar.add(Calendar.DATE,7);
					Date nextWeekEnd = calendar.getTime();
					events[i].setEndDate(nextWeekEnd);
					
				}
				
				/* WIP
				 * otherwise remove it from the collection */
				
			}
	}


	/**
	 * Draw events
	 */
	
	public void paint(Graphics pane) {
			if (events!= null){				//Paint all the events onto the screen
				for(int i = 0; i<size; i++)
					events[i].paint(pane);
			}


	}
	
	/**
	 * Displays the events on the console
	 */
	public void display()
	{
		System.out.println("---EVENTS---\n");
		for(int i =0; i<size; i++)
		{
			System.out.println(events[i].getName());	//Display name
			System.out.println("---Start Date:  " +events[i].getStartDate());	//Display start date
			System.out.println("---End Date:  " +events[i].getEndDate());		//end date
			System.out.println("---Location:  " +events[i].getLoc());			//location
			System.out.println("---Materials:  " +events[i].getMaterials());	//materials
			System.out.println();
		}
		
	}

	/**
	 * This method adjusts the x and y coordinates of the events
	 * in the collection
	 */
	public void adjust() 
	{
		int x = 400;	//First event's coordinates
		int y = 200;
		
		for(int i =0; i<size; i++)
		{
			events[i].setX(x);	//Set the coordinates
			events[i].setY(y);
			y+=40;	
			
		}
		
	}


	

}
