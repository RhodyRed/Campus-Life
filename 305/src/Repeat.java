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

	private Timer timer;			//The timer
	private String currentDate;		//Current date
	private EventCollection collection;		//The event collection
	private Calendar calendar;				//Calendar
	private Date d;					//To hold current date in date format
	SimpleDateFormat formatter = new SimpleDateFormat("M/dd/yyyy K:mm a");	//Format of the date+time
	private Date d2;	//Altered date

	
	public Repeat(EventCollection collection) 
	{

		this.collection = collection;	
	    timer = new Timer(this); //Creates a timer
	    timer.start();	//Starts timer
	    
	
	}
	
	public void refresh() {
		timer.setPeriod(60000); //Timer set to 1 second (60000 milisecs)
		calendar = Calendar.getInstance(TimeZone.getDefault());	//Get calendar instance
		d = calendar.getTime();	//Get current date
		currentDate = formatter.format(d);	//Format current date
		try {
			d2 = new SimpleDateFormat("MM/dd/yyyy K:mm a").parse(currentDate);	//Reformat current date
		} catch (ParseException e) {

		   e.printStackTrace();
	   }
		 
		
		moveEvent();	//Compare dates
		
		
	}

	/**
	 * This method keeps going through the collection and checking
	 * if any of the event's end time is equal to the current time
	 * if so then you move it to the next day that it should repeat
	 */
	private void moveEvent() {
			collection.compareDates(d2); //Compare the dates

		}
		
		
	}
	


