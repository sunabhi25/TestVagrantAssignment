package utilities;

/*
 * This class is responsible for doing the comparison of Max Temperature for the week with the todays temperature if 
 * the temperature difference is between specified range then it will pass the test or else it will throw the user 
 * the custom exception 
 * 
 * @author Abhishek Shandilya
 * 
 */

import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import commonUtilities.BaseTestUI;
import customExceptions.OutOfPermissableRange;
import extentReports.ExtentTestManager;

public class OneWeekTemperatureComparator extends BaseTestUI {

	public static SoftAssert softAssertion = new SoftAssert();

	public boolean compareTemperatureOfWeek(int todayTemp, int otherDaysTemp, int range) {
		if (todayTemp == otherDaysTemp) {
			ExtentTestManager.getTest().log(Status.PASS,
					"Today temperrature comaprison with other day -> " + " Today Temperature is -> " + todayTemp
							+ " and other day temperature is -> " + otherDaysTemp
							+ " Both days temperatures are same ->" + todayTemp + " == " + otherDaysTemp);
			return todayTemp == otherDaysTemp;
		}
		if (todayTemp > otherDaysTemp) {
			if ((todayTemp - otherDaysTemp) == range) {
				ExtentTestManager.getTest().log(Status.PASS,
						"Today temperrature comaprison with other day -> " + " Today Temperature is -> " + todayTemp
								+ " and other day temperature is -> " + otherDaysTemp
								+ " Differnece of temperature of both days is -> " + (todayTemp - otherDaysTemp)
								+ " the temperature difference is same as the permissable range " + range);

			} else if ((todayTemp - otherDaysTemp) < range) {
				ExtentTestManager.getTest().log(Status.PASS,
						"Today temperrature comaprison with other day -> " + " Today Temperature is -> " + todayTemp
								+ " and other day temperature is -> " + otherDaysTemp
								+ " Differnece of temperature of both days is -> " + (todayTemp - otherDaysTemp)
								+ " the temperature difference is less than the permissable range " + range);
			}
			try {
				if ((todayTemp - otherDaysTemp) > range) {
					throw new OutOfPermissableRange(
							"Today temperrature comaprison with other day -> " + " Today Temperature is -> " + todayTemp
									+ " and other day temperature is -> " + otherDaysTemp
									+ " Differnece of temperature of both days is -> " + (todayTemp - otherDaysTemp)
									+ " the temperature difference is more than the permissable range " + range);
				}
			} catch (OutOfPermissableRange outOfPermissableException) {
				outOfPermissableException.printStackTrace();
				ExtentTestManager.getTest().log(Status.FAIL, outOfPermissableException);
				softAssertion.assertEquals((todayTemp - otherDaysTemp), range);
				softAssertion.assertAll();

			}
			return (todayTemp - otherDaysTemp) < range;
		}
		if (todayTemp < otherDaysTemp) {
			if ((todayTemp - otherDaysTemp) == range) {
				ExtentTestManager.getTest().log(Status.PASS,
						"Today temperrature comaprison with other day -> " + " Today Temperature is -> " + todayTemp
								+ " and other day temperature is ->" + otherDaysTemp
								+ " Differnece of temperature of both days is -> " + (todayTemp - otherDaysTemp)
								+ " the temperature difference is same as the permissable range -> " + range);
			}
			try {
				if ((otherDaysTemp - todayTemp) > range) {
					throw new OutOfPermissableRange(
							"Today temperrature comaprison with other day -> " + " Today Temperature is -> " + todayTemp
									+ " and other day temperature is ->" + otherDaysTemp
									+ " Differnece of temperature of both days is -> " + (otherDaysTemp - todayTemp)
									+ " the temperature difference is more than permissable range -> " + range);
				}
			} catch (OutOfPermissableRange outOfPermissableException) {
				outOfPermissableException.printStackTrace();
				ExtentTestManager.getTest().log(Status.FAIL, outOfPermissableException);
				softAssertion.assertEquals((todayTemp - otherDaysTemp), range);
				softAssertion.assertAll();
			}
			if ((otherDaysTemp - todayTemp) < range) {
				ExtentTestManager.getTest().log(Status.PASS,
						"Today temperrature comaprison with other day -> " + " Today Temperature is -> " + todayTemp
								+ " and other day temperature is ->" + otherDaysTemp
								+ " Differnece of temperature of both days is -> " + (otherDaysTemp - todayTemp)
								+ " the temperature difference is less than permissable range -> " + range);
			}
			return (otherDaysTemp - todayTemp) > range;
		} else
			return false;
	}
}