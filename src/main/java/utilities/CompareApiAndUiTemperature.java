package utilities;

/*
 * 
 * With the help of this class we are able to do the comparision of both UI and API and Max Temperature of today with next six days
 * 
 */

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import commonUtilities.ApiUtilities;
import commonUtilities.PropertyManager;
import extentReports.ExtentTestManager;
import objectRepository.HomePage;
import objectRepository.SearchLocationPage;
import objectRepository.WeatherForecastPage;

public class CompareApiAndUiTemperature {
	
	public static void getApiTemperatureDetails() {
		ApiUtilities apiUtilities = new ApiUtilities();
		apiUtilities.responseBody("main", "temp");
		ConversionCalculation utility = new ConversionCalculation();
//		System.out.println(utility.roundOffCelsiusTemperature());
		utility.roundOffCelsiusTemperature();
	}

	/*
	 * Method to get the temeperature from the UI
	 */
	public static void getUiTempearture(WebDriver driver) {
		HomePage homePage = new HomePage(driver);
		homePage.enterCityName("Patna, Bihar");
		SearchLocationPage searchLocationPage = new SearchLocationPage(driver);
		searchLocationPage.clickOnLocations();
	}

	/*
	 * Method to get the temperature of the today and last six days
	 */
	public static void getTemperatureForTodayAndLastSixDays(WebDriver driver) {
		ExtentTestManager.getTest().log(Status.INFO,"Temperature Differnece between Today with Last Six Days Test Started -------->>>>> ");
		CompareApiAndUiTemperature.getUiTempearture(driver);
		System.out.println(WeatherForecastPage.currentWeatherOfSerachedLocation);
		WeatherForecastPage weatherForecastPage = new WeatherForecastPage(driver);
		weatherForecastPage.getTodayAndLastSixDayTemperature();
		MaxTemperatureCalculation maxTempeartureCalculations = new MaxTemperatureCalculation();
		maxTempeartureCalculations.nextDaysTemperature(weatherForecastPage.todayAndLastSixDaysHighTemperature);
		ExtentTestManager.getTest().log(Status.INFO,"Temperature Differnece between Today with Last Six Days Test Ended -------->>>>> ");
	}

	/*
	 * Method to get the temperature of the today and next six days
	 */
	public static void getTemperatureForTodayAndNextSixDays(WebDriver driver) {
		ExtentTestManager.getTest().log(Status.INFO,"Temperature Differnece between Today with Next Six Days Test Started -------->>>>> ");
		CompareApiAndUiTemperature.getUiTempearture(driver);
		System.out.println(WeatherForecastPage.currentWeatherOfSerachedLocation);
		WeatherForecastPage weatherForecastPage = new WeatherForecastPage(driver);
		weatherForecastPage.getTodayAndNextSixDayTemperature();
		MaxTemperatureCalculation maxTempeartureCalculations = new MaxTemperatureCalculation();
		maxTempeartureCalculations.nextDaysTemperature(weatherForecastPage.todayAndNextSixDaysHighTemperature);
		ExtentTestManager.getTest().log(Status.INFO,"Temperature Differnece between Today with Next Six Days Test Ennded -------->>>>> ");
	}

	/*
	 * Method to compare the UI and API Temperature
	 * 
	 * @param WebDriver
	 */
	public static void compareUiAndApiTemperature(WebDriver driver) {
		PropertyManager.loadConfig();
		ExtentTestManager.getTest().log(Status.INFO,"UI and API Tempearture Comparator Test Started -------->>>>> ");
		CompareApiAndUiTemperature.getApiTemperatureDetails();
		CompareApiAndUiTemperature.getUiTempearture(driver);
		UIandAPITemperatureComparator uIandApiTemperatureComparator = new UIandAPITemperatureComparator();
		uIandApiTemperatureComparator.compareUIandAPITemp(WeatherForecastPage.currentWeatherOfSerachedLocation,
				ConversionCalculation.roundOffCelsiusTemperature(),
				Integer.parseInt(PropertyManager.prop.getProperty("range")));
		ExtentTestManager.getTest().log(Status.INFO,"UI and API Tempearture Comparator Test Ended -------->>>>> ");
	}

}
