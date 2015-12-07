import java.awt.Graphics;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


public class ArrayEventCollection implements EventCollection
{
	
	private final int SIZE = 100; //Default size
	private Event [] events;
	private int size;
	private int selected;
	private Calendar calendar;
	
	public ArrayEventCollection()
	{
		events = new Event[SIZE];
		size = 0;
		selected = -1;
		
				
	}
	
	/**
	 *  changes the selected event
	 */
	public void changeSelection(int newSelection)
	{
		selected = newSelection;
	}
	
	/**
	 * adds an event
	 */
	public void add(Event someEvent) {
		if(selected == events.length)
		{
			Event[] temp = new Event[events.length*2];
			for(int i = 0; i<events.length; i++)
			{
				temp[i] = events[i];
				events = temp;
			}
		}
		events[size] = someEvent;
		changeSelection(size++);
		
		
	}

	/**
	 * removes an event
	 */

	public void remove() 
	{
			for (int i = selected ; i < size-1; i++)
				events[i] = events[i+1];
			size--;
			changeSelection(-1);
		
	}


	/**
	 * resets to the beginning of the collection
	 */
	public void reset() {

		changeSelection(0);
	}


	public void reset(Event someEvent) {
		
		int i = 0;							
		changeSelection(-1);					
		while (selected == -1 && i < size) 
		{
			if (events[i] == someEvent)
				changeSelection(i);
			i++;
		}
		

		
	}


	public boolean hasNext() {

		return (size > 0) && (selected >= 0) && (selected < size);
	}
	
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
				
				/* otherwise remove it from the collection */
				
			}
	}


	public void paint(Graphics pane) {
		
	}
	
	public void display()
	{
		System.out.println("---EVENTS---");
		for(int i =0; i<size; i++)
		{
			System.out.println(events[i].getName()+ ": "+events[i].getStartDate());
			
		}
		
	}


	

}
