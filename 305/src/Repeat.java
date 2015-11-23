/**
 * WORK IN PROGRESS
 * This class is for checking the time and checks if the current date+time is 
 * equal to one of the events in the collection's end date+time, then it checks
 * if that event will have any repeating days and move that event into the next date
 */
public class Repeat implements TimerListener {

	private Timer timer;
	private String time;
	private String date;
	private EventCollection collection;

	
	public Repeat(EventCollection collection, String time, String date) 
	{
		this.time = time;
		this.date = date;
		this.collection = collection;
		
	    timer = new Timer(this); //Creates a timer
	    timer.start();
	
	}
	
	public void refresh() {
		System.out.println(time);
		timer.setPeriod(60000); //Timer set to 60000 milisecs here (1 second)
		
	}



}
