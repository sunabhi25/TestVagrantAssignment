package objectRepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import commonUtilities.GenericUtils;
import commonUtilities.UIVerification;
import extentReports.ExtentTestManager;

public class WeatherForecastPage extends UIVerification {
	private static final String currentWeather = "(//div[@class='temp'])[1]";
	public static String currentWeatherTemp;
	public static int currentWeatherOfSerachedLocation;
	public static final String monthly = "//a/h3[.='Monthly']";
	public static final String getDate = "//a[@class='monthly-daypanel   is-today']//div[@class='date']";
	public static String getCurrentDate;
	public static int date;
	public static String highTemperature = "(//div[@class='monthly-panel-top']//div[@class='date']/..//div[contains(.,'"+ date + "')])[1]/../..//div[@class='temp']//div[contains(@class,'high')]";
	public static  int count = 0;
	public static String temperature;
	public static List<String> todayAndLastSixDaysHighTemperature = new ArrayList<String>();
	public static List<String> todayAndNextSixDaysHighTemperature = new ArrayList<String>();
	
	public WeatherForecastPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String getCurrentTemperature() {
		currentWeatherTemp = GenericUtils.getText("xpath", currentWeather);
		getLogs(this.getClass());
		logger.info("Current Weather Temperature is " + currentWeatherTemp);
		ExtentTestManager.getTest().log(Status.INFO, "Current Weather Temperature is " + currentWeatherTemp);
		return currentWeatherTemp;
	}

	public int currentWeatherListDetails() {
//		currentWeathersList = new ArrayList<String>();
//		currentWeathersList.add(Integer.parseInt(currentWeather.substring(0,currentWeather.length()-1)));
		currentWeatherOfSerachedLocation = Integer
				.parseInt(getCurrentTemperature().substring(0, getCurrentTemperature().length() - 2));
//		System.out.println(currentWeathersList);
		getLogs(this.getClass());
		logger.info("Current Weather Temperature of the searched place is " + currentWeatherOfSerachedLocation);
		ExtentTestManager.getTest().log(Status.INFO, "Current Weather Temperature of the searched place is " + currentWeatherOfSerachedLocation);
		return currentWeatherOfSerachedLocation;
	}

	public List<String> getTodayAndLastSixDayTemperature() {
		GenericUtils.clickElement("xpath", monthly);
		getCurrentDate = GenericUtils.getText("xpath", getDate); 
		date = Integer.parseInt(getCurrentDate); 
		for(int i =date-count; ;i--) {
			date=i;
			highTemperature = "(//div[@class='monthly-panel-top']//div[@class='date']/..//div[contains(.,'"+ date + "')])[1]/../..//div[@class='temp']//div[contains(@class,'high')]";
			if(GenericUtils.getElement("xpath", highTemperature).isDisplayed()) {
				temperature = GenericUtils.getText("xpath", highTemperature);
				todayAndLastSixDaysHighTemperature.add(temperature.substring(0,temperature.length()-1));
				date=i;
				count++;
				if(count==7)
					break;
			}else {
				todayAndLastSixDaysHighTemperature.add("N/A");
				date=i;
				count++;
				if(count==7)
					break;
			}
		}
		getLogs(this.getClass());
		logger.info("Weather Temperature of today and last six days are " + todayAndLastSixDaysHighTemperature);
		ExtentTestManager.getTest().log(Status.INFO, "Weather Temperature of today and last six days are " + todayAndLastSixDaysHighTemperature);
		return todayAndLastSixDaysHighTemperature;
	}
	
	public List<String> getTodayAndNextSixDayTemperature() {
		GenericUtils.clickElement("xpath", monthly);
		getCurrentDate = GenericUtils.getText("xpath", getDate); 
		date = Integer.parseInt(getCurrentDate); 
		for(int i =date+count; ;i++) {
			date=i;
			highTemperature = "(//div[@class='monthly-panel-top']//div[@class='date']/..//div[contains(.,'"+ date + "')])[1]/../..//div[@class='temp']//div[contains(@class,'high')]";
			if(GenericUtils.getElement("xpath", highTemperature).isDisplayed()) {
				temperature = GenericUtils.getText("xpath", highTemperature);
				todayAndNextSixDaysHighTemperature.add(temperature.substring(0,temperature.length()-1));
				date=i;
				count++;
				if(count==7)
					break;
			}else {
				todayAndNextSixDaysHighTemperature.add("N/A");
				date=i;
				count++;
				if(count==7)
					break;
			}
		}
		getLogs(this.getClass());
		logger.info("Weather Temperature of today and next six days are " + todayAndNextSixDaysHighTemperature);
		ExtentTestManager.getTest().log(Status.INFO, "Weather Temperature of today and next six days are " + todayAndNextSixDaysHighTemperature);
		return todayAndNextSixDaysHighTemperature;
	}
}
