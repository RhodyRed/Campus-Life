import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Enables user to Scrape current weather info
 * off the web.
 *
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * !!!!!  MUST HAVE JSOUP ADDED TO LIB  !!!!!
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * 
 * Usage:
 * -getCondition() = Grab Current Weather Condition Icon
 * -getTemperature() = Grab Current Temperature (Text Form)
 * -getWeatherIcon() = Grab Current Condition (Text Form)
 */
public class WeatherScraper 
{
	public WeatherScraper(){}
	
	
	/**
	 * Connects web scraper to 
	 * selected website
	 */
	private Document getPage(String website) throws Exception
	{
		Document page = Jsoup.connect(website).get();
		
		return(page);
	}
	
	
	/**
	 * Scrapes website for current 
	 * days weather icon. Then Grabs
	 * the Source URL for the icon
	 */
	private String getIconURL(Document page) throws Exception
	{
		
		//Grabs the first table of weather icons
		Element weatherTable = page.select("div.weather-widget").get(0);
		
		//Grabs the first icon in table (Current Day)
		Element icon = weatherTable.select("img[src*=.png]").get(0);
		
		//Returns source URL of image
		return( icon.absUrl("src") );
	}
	
	
	/**
	 * Grabs current weather condition icon
	 * from: accuweather.com
	 * for: South Kingstown RI
	 * 
	 * On Error uses default No Connection Icon
	 * from: src/images/noConnection.png
	 */
	public BufferedImage getWeatherIcon() 
	{
		BufferedImage image = null;
		
		try 
		{
			//Grab Weather Condition Icon from Web
			String path = getIconURL(getPage("http://openweathermap.org/city/7257663"));
            URL url = new URL(path);
            image = ImageIO.read(url);
        } 
		catch (Exception e) 
		{
			//Use Default No Connection Image
			try
			{
				image = ImageIO.read(new File("src/images/noConnection.png"));
			}catch(Exception ex){System.out.println("File Path for Weather Scraper Default Weather Icon is wrong. Expected: src/images/noConnection.png");};
			
        }
		
		return(image);
	}
		
	
	/**
	 * Grabs Current Temp in degrees Fahrenheit
	 * from: accuweather.com
	 * for: South Kingstown RI
	 */
	public String getTemperature()
	{
		//Default Temp 
		String temp = "---";
		
		try
		{
			//Grab Temperature Data From Web
			Document page = getPage("http://www.accuweather.com/en/us/south-kingstown-ri/02879/current-weather/2632755");
			Elements temps = page.select("span.temp");
			
			//Get Current Temp
			temp = temps.get(0).text();
		}
		catch(Exception e){}
		
		return(temp);
	}
	
	
	/**
	 * Grabs current weather condition
	 * in text form
	 * from: accuweather.com
	 * for: South Kingstown RI
	 */
	public String getCondition()
	{
		//Default Condition 
		String cond = "";
		
		try
		{
			//Grab Condition Data From Web
			Document page = getPage("http://www.accuweather.com/en/us/south-kingstown-ri/02879/current-weather/2632755");
			Elements conds = page.select("span.cond");
			
			//Get Current Condition
			cond = conds.get(5).text();
		}
		catch(Exception e){}
		
		return(cond);
	}

	
}
