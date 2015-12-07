import java.text.ParseException;
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
	private Date d2;

	
	public Repeat(EventCollection collection) 
	{

		this.collection = collection;
		
	    timer = new Timer(this); //Creates a timer
	    timer.start();
	    
	
	}
	
	public void refresh() {
		timer.setPeriod(1000); //Timer set to 1 second
		calendar = Calendar.getInstance(TimeZone.getDefault());
		d = calendar.getTime();
		currentDate = formatter.format(d);
		try {
			d2 = new SimpleDateFormat("MM/dd/yyyy K:mm a").parse(currentDate);
		} catch (ParseException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
	   }
		 
		
		moveEvent();
		
		
	}

	/**
	 * This method keeps going through the collection and checking
	 * if any of the event's end time is equal to the current time
	 * if so then you move it to the next day that it should repeat
	 */
	private void moveEvent() {
			collection.compareDates(d2);

		}
		
		
	}
	


