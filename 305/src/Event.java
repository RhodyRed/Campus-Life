import java.awt.Color;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Event {
	
	private String name;	//Name of the event
	private Date start;		//Start date of the event
	private Date end;		//End date of the event
	private String loc;		//Location
	private String materials;		//Materials
	private int[] repeat;			//Array of days for repeat
	
	private boolean repeatDays = false;		//Days that are repeating
	private boolean repeatSun = false;
	private boolean repeatMon = false;
	private boolean repeatTue = false;
	private boolean repeatWed = false;
	private boolean repeatThu = false;
	private boolean repeatFri = false;
	private boolean repeatSat = false;
	
	private int x;	//Coordinates of the events
	private int y;	//for drawing..
	
	private String startDate;	//Dates+times formatted as strings
	private String startTime;
	private String endDate;
	private String endTime;
	
	SimpleDateFormat formatter = new SimpleDateFormat("M/d/yyyy");			//Format of the date
    SimpleDateFormat df = new SimpleDateFormat("K:mm:ss a"); 				//Format of the time

	
	
	public Event(){
		
	}
	
	/**
	 * Constructor, not entirely sure what the types will be for date & time,
	 * will say string for now
	 */
	public Event(String n, Date s, Date e, String l, String mat, int[] r)
	{
		name = n;			//Set the event properties
		setStartDate(s);
		setEndDate(e);
		loc = l;
		materials = mat;
		repeat = r;
		
		
		checkForRepeats();		//Check for repeating days

	}
	
	
	public void setX(int val)
	{
		x = val;	//Set the x coordinate
	}
	public void setY(int val)
	{
		y = val;	//Set the y coordinate
	}
	
	public void setStartDate(Date s) {
		start = s;	//Set the start date
	    startTime = df.format(start);			//Format the start time
	    startDate = formatter.format(start);		//Format the  start date
		
	}
	public void setEndDate(Date e)
	{
		end = e;	//Set the end date
	    endDate = formatter.format(end);		//Format the end date
		endTime = df.format(end);				//Format the end time
	}

	

	
	private void checkForRepeats() {
		
		if (repeat != null)	//If there are repeating days
		{
			repeatDays(true);	//The event repeating is true 

			for(int i = 0; i<repeat.length; i++)	 //Check which day
			{
				if(repeat[i] == 0)
				{
					setSunRepeat(true);
				}
				else if (repeat[i] == 1)
				{
					setMonRepeat(true);
				}
				else if (repeat[i] == 2)
				{
					setTueRepeat(true);
				}
				else if (repeat[i] == 3)
				{
					setWedRepeat(true);
				}
				else if (repeat[i] == 4)
				{
					setThuRepeat(true);
				}
				else if (repeat[i] == 5)
				{
					setFriRepeat(true);
				}
				else if (repeat[i] == 6)
				{
					setSatRepeat(true);
				}
			} // end for
		} //end if
		
	}
	//end method



	/**
	 * Maybe check everyday if we have any events that have repeatDays = true, if so then we save onto this event
	 * for future use, otherwise the garbage collector takes the event if it's over and isnt repeating?
	 */
	public void repeatDays(boolean b)
	{
		repeatDays  = b;
	}
	
	public void setSunRepeat(boolean b)
	{
		repeatSun = b;
	}
	
	public void setMonRepeat(boolean b)
	{
		repeatMon = b;
	}
	public void setTueRepeat(boolean b) 
	{
		repeatTue = b;

	}
	public void setWedRepeat(boolean b) 
	{
		repeatWed = b;

	}
	public void setThuRepeat(boolean b) 
	{
		repeatThu = b;

	}
	public void setFriRepeat(boolean b) 
	{
		repeatFri = b;

	}
	public void setSatRepeat(boolean b) 
	{
		repeatSat = b;

	}
	
	
	
	/**
	 * Getter methods
	 * 
	 */
	public boolean getRepeatDays()
	{
		return repeatDays;
	}
	
	public boolean getSunRepeat()
	{
		return repeatSun;
	}
	
	public boolean getMonRepeat()
	{
		return repeatMon;
	}
	public boolean getTueRepeat() 
	{
		return repeatTue;

	}
	public boolean getWedRepeat() 
	{
		return repeatWed;

	}
	public boolean getThuRepeat() 
	{
		return repeatThu;

	}
	public boolean getFriRepeat() 
	{

		return repeatFri;
	}
	public boolean getSatRepeat() 
	{

		return repeatSat;
	}
	
	
	public String getName()
	{
		return name;
	}
	
	public Date getStartDate()
	{
		return start;
		
	}
	public Date getEndDate()
	{
		return end;
		
	}

	
	
	public String getLoc()
	{
		return loc;
	}
	
	public String getMaterials()
	{
		return materials;
	}
	
	
	/**
	 * Setter methods
	 * 
	 */
	
	
	public void setName(String newname)
	{
		name = newname;
	}
	
	
	public void getLoc(String newLoc)
	{
		loc = newLoc;
	}
	
	public void setMaterials(String newMaterials)
	{
		materials = newMaterials;
	}

	public void paint(Graphics pane) {
		pane.setColor(Color.black);
		pane.drawString(name+ ": ", x, y);	//Draw the name
		pane.drawString(startDate + " ---- " + startTime, x+120, y+19);	//Draw the start date+time
		pane.drawRect(x-10, y-20, 280, 40);
	}


}
