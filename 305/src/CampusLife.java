
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;


public class CampusLife {
	
	// Instantiate the welcome screen
	private WelcomeScreen campusLife;

	
	
	public static void main(String[] args)
	{

		initialize();
	}
	
	/**
	 * initialize the program
	 */
	public static void initialize()
	{
		
		
		WelcomeScreen campusLife = new WelcomeScreen();
		
		

		campusLife.setSize(800,600); //just some random size and color	
		campusLife.setVisible(true);

	}
	
	
	

}
