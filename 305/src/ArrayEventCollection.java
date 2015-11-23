import java.awt.Graphics;


public class ArrayEventCollection implements EventCollection
{
	
	private final int SIZE = 100; //Default size
	private Event [] events;
	private int size;
	private int selected;
	
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


	public void paint(Graphics pane) {

		
		
	}
	
	public void display()
	{
		for(int i =0; i<events.length; i++)
		{
			System.out.println(events[i].getName());
			
		}
		
	}
	

}
