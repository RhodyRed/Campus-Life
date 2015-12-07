import java.util.Date;


public class Event {
	
	private String name;
	private Date start;
	private Date end;
	private String loc;
	private String materials;
	private int[] repeat;
	private boolean repeatDays = false;
	private boolean repeatSun = false;
	private boolean repeatMon = false;
	private boolean repeatTue = false;
	private boolean repeatWed = false;
	private boolean repeatThu = false;
	private boolean repeatFri = false;
	private boolean repeatSat = false;
	
	public Event(){
		
	}
	
	/**
	 * Constructor, not entirely sure what the types will be for date & time,
	 * will say string for now
	 */
	public Event(String n, Date s, Date e, String l, String mat, int[] r)
	{
		name = n;
		setStartDate(s);
		setEndDate(e);
		loc = l;
		materials = mat;
		repeat = r;
		checkForRepeats();

	}
	
	public void setStartDate(Date s) {
		start = s;
		
	}
	public void setEndDate(Date e)
	{
		end = e;
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


}
