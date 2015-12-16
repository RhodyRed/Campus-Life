
/**
 * This class defines a timer in which it refreshes after a set delay
 * 
 */


public class Timer extends Thread 
{
	
	private TimerListener listener;	//The timer object
	private int delay = 0;	//Initial delay
	
	
	/**
	 * Constructor
	 */
	public Timer(TimerListener someTimer)
	{
		listener = someTimer;	//Set the timer
	}
	
	/**
	 * This method gets passed in a value to be
	 * used as our delay on the timer
	 */
	public void setPeriod(int someDelay)
	{									
		delay = someDelay;	//Get the delay in milliseconds
	}


	/**
	 * This method sets the delay on the timer
	 * and refreshes it based on the delay value
	 */
	private void setPeriodicTime(int someDelay)
	{
		delay = someDelay;	//Set the delay

		try {
			while (true){					//Keep refreshing based on delay	
				Thread.sleep(delay);		//value that is passed
				if (listener != null)		
					listener.refresh();		//Refresh
			}									
		}
		catch(InterruptedException e) {
			System.err.println("Error");	//Error occured
		}
	}

	/**
	 * Method to start the thread 
	 */
	public void run()
	{

		setPeriodicTime(delay);
	}

}
