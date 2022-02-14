package utilities;

import com.aventstack.extentreports.Status;

import commonUtilities.BaseTestUI;
import extentReports.ExtentTestManager;
import objectRepository.WeatherForecastPage;

public class OneWeekTemperatureComparator extends BaseTestUI {

	public boolean compareTemperatureOfWeek(int todayTemp, int otherDaysTemp, int range) {
		if (todayTemp == otherDaysTemp) {
			ExtentTestManager.getTest().log(Status.INFO,
					"Today temperrature comaprison with other day -> " + " Today Temperature is -> " + todayTemp
							+ " and other day temperature is -> " + otherDaysTemp
							+ " Both days temperatures are same ->" + todayTemp + " == " + otherDaysTemp);
			return todayTemp == otherDaysTemp;
		}
		if (todayTemp >= otherDaysTemp) {
			ExtentTestManager.getTest().log(Status.INFO,
					"Today temperrature comaprison with other day -> " + " Today Temperature is -> " + todayTemp
							+ " and other day temperature is -> " + otherDaysTemp
							+ " Differnece of temperature of both days is -> " + (todayTemp - otherDaysTemp)
							+ " the temperature difference is less than permissable range " + range);
			return (todayTemp - otherDaysTemp) < range;
		} else {
			ExtentTestManager.getTest().log(Status.INFO,
					"Today temperrature comaprison with other day -> " + " Today Temperature is -> " + todayTemp
							+ " and other day temperature is ->" + otherDaysTemp
							+ " Differnece of temperature of both days is -> " + (otherDaysTemp - todayTemp)
							+ " the temperature difference is less than permissable range -> " + range);
			return (otherDaysTemp - todayTemp) < range;
		}
	}
}