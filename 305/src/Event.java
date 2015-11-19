
public class Event {
	
	private String name;
	private int day;
	private int month;
	private int year;
	private int hour;
	private int minute;
	private int amORpm;
	private String loc;
	private String materials;
	private int[] repeat;
	
	private boolean repeatSun = false;
	private boolean repeatMon = false;
	private boolean repeatDays = false;
	
	public Event(){
		
	}
	
	/**
	 * Constructor, not entirely sure what the types will be for date & time,
	 * will say string for now
	 */
	public Event(String n, int m,  int d, int y, int h, 
						int min, int ampm, String l, String mat, int[] r)
	{
		
		name = n;
		month = m;
		day = d;
		hour = h;
		minute = min;
		amORpm = ampm;
		loc = l;
		materials = mat;
		repeat = r;
		checkForRepeats();
	}
	

	
	private void checkForRepeats() {
		
		if (repeat != null)
		{
			repeatDays(true);
			for(int i = 0; i<repeat.length; i++)
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
		
	} //end method

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
	
	/**
	 * rest of the week
	 */
	
	
	
	
	
	/**
	 * Getter methods
	 * 
	 */
	
	public String getName()
	{
		return name;
	}
	
	public int getMonth()
	{
		return month;
	}
	
	public int getDay()
	{
		return day;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public int getHour()
	{
		return hour;
	}
	
	public int getMinute()
	{
		return minute;
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
	 * format the time into a string maybe?

	public String getTime()
	{

		return time;
	}
	*/
	
	
	/**
	 * Setter methods
	 * 
	 */
	
	public void setName(String newname)
	{
		name = newname;
	}
	
	public void setMonth(int newMonth)
	{
		month = newMonth;
	}
	
	public void setDay(int newDay)
	{
		day = newDay;
	}
	
	public void setYear(newYear)
	{
		year = newYear;
	}
	
	public void setHour(int newHour)
	{
		hour = newHour;
	}
	
	public void getMinute(int newMinute)
	{
		minute = newMinute;
	}
	
	public void getLoc(String newLoc)
	{
		loc = newLoc;
	}
	
	public void setMaterials(String newMaterials)
	{
		materials = newMaterials;
	}

}
