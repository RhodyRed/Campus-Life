import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JPanel;

public class CalyTheCalendar extends JPanel
{
	/**
	 * Structures the format of the date
	 */
	private SimpleDateFormat month = new SimpleDateFormat("MMMM"),
			year = new SimpleDateFormat("yyyy"),
			day = new SimpleDateFormat("d");
	
	/**
	 * Current date being displayed
	 */
	private Date date = new Date();
	
	
	/**
	 * Create new Calendar with current date
	 */
	public CalyTheCalendar()
	{
		this.setDate(new Date());
	}
	
	
	/**
	 * Select the date that calendar displays
	 */
	private void setDate(Date date) 
	{
	    this.date = date;
	}
	
	
	/**
	 * Output the calendar to a window
	 * to be displayed
	 */
	public void displayCalendar(Graphics pane, int xPos, int yPos)
	{
		pane.setColor(Color.darkGray);
		pane.fillRect(xPos, yPos, 300, 300);
		((Graphics2D) pane).setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
	    pane.fillRect(xPos, yPos, 300, 300);
	    pane.setColor(Color.WHITE);
	    pane.drawString(month.format(date), xPos+ 34,yPos+ 36);
	    pane.setColor(Color.white);
	    pane.drawString(year.format(date),xPos+ 235,yPos+ 36);

	    Calendar today = Calendar.getInstance();
	    today.setTime(date);
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    cal.set(Calendar.DATE, 1);
	    cal.add(Calendar.DATE, -cal.get(Calendar.DAY_OF_WEEK) + 1);
	    for (int week = 0; week < 6; week++) {
	      for (int d = 0; d < 7; d++) {
	        Color col = Color.WHITE;
	          pane.drawString(day.format(cal.getTime()), xPos+d * 30 + 46 + 4,
	        		  yPos+ week * 29 + 81 + 20);
	        cal.add(Calendar.DATE, +1);
	      }
	    }
	}
}
