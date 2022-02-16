package accuWeatherTestRunner;

/*
 * This class will execute the test cases this class currently has three test cases
 * 
 * @author Abhishek Shandilya
 */
import org.testng.annotations.Test;

import commonUtilities.BaseTestUI;
import utilities.CompareApiAndUiTemperature;

public class TestCase_01_UIAndAPI_TemperatureComparison extends BaseTestUI {
	
	/*
	 * This method will execute the test case to compare UI and API Temperature 
	 * It will call the method to compare and check whether it is in specific range or not
	 */
	  @Test(priority = 1)
	  public static void compare_UI_And_API_Temperature() {
		  CompareApiAndUiTemperature.compareUiAndApiTemperature(driver);
	  }
	  
	  /*
	   * This method will execute the test case to compare Today and Next six days high temperature 
	   * It will call the method to compare and check whether it is in specific range or not
	   */
	  @Test(priority = 2)
	  public static void compareUpcomingWeekTemperatureWithToday() {
		  CompareApiAndUiTemperature.getTemperatureForTodayAndNextSixDays(driver);
	  }
	  
	  /*
	   * This method will execute the test case to compare Today and last six days high temperature 
	   * It will call the method to compare and check whether it is in specific range or not
	   */
	  @Test(priority = 3)
	  public static void comparePastWeekTemperatureWithToday() {
		  CompareApiAndUiTemperature.getTemperatureForTodayAndLastSixDays(driver);
	  }
	 
}
