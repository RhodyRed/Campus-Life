
public class Timer extends Thread 
{
	
	private TimerListener listener;
	private int delay = 0;
	
	public Timer(TimerListener someTimer)
	{
		listener = someTimer;
	}
	
	
	public void setPeriod(int someDelay)
	{									
		delay = someDelay;
	}



	private void setPeriodicTime(int someDelay)
	{
		delay = someDelay;

		try {
			while (true){						
				Thread.sleep(delay);			
				if (listener != null)		
					listener.refresh();
			}									
		}
		catch(InterruptedException e) {
			System.err.println("Error");
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
