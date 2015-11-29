import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * WORK IN PROGRESS
 * This class is for checking the time and checks if the current date+time is 
 * equal to one of the events in the collection's end date+time, then it checks
 * if that event will have any repeating days and move that event into the next date
 */
public class Repeat implements TimerListener {

	private Timer timer;
	private String currentDate;
	private EventCollection collection;
	private Calendar calendar;
	private Date d;
	SimpleDateFormat formatter = new SimpleDateFormat("M/dd/yyyy K:mm a");

	
	public Repeat(EventCollection collection) 
	{

		this.collection = collection;
		
	    timer = new Timer(this); //Creates a timer
	    timer.start();
	    
	
	}
	
	public void refresh() {
		timer.setPeriod(100000); //Timer set to 60000 milisecs here (1 second)
		calendar = Calendar.getInstance(TimeZone.getDefault());
		d = calendar.getTime();
	    currentDate = formatter.format(d);
		System.out.println(currentDate);
		
		 
		
		moveEvent();
		
		
	}

	/**
	 * This method keeps going through the collection and checking
	 * if any of the event's end time is equal to the current time
	 * if so then you move it to the next day that it should repeat
	 */
	private void moveEvent() {
		
		
	}
	



}
