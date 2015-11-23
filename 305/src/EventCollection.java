import java.awt.Graphics;


public interface EventCollection {
	
	//Adds an event
	public void add(Event someEvent);
	
	
	//Removes an event
	public void remove();
	
	
	//Resets the collection to the beginning
	public void reset();
	
	//If the event is in the collection
	//that event is the selected event
	public void reset(Event someEvent);
	
	public boolean hasNext();
	
	public void paint(Graphics pane);


	public void display();

	

}
