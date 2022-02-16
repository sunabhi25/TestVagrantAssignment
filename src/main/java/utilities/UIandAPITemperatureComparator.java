package utilities;

/*
 * This class is responsible for doing the comparison of UI Temperature and API Temperature and if the temperature difference
 * is between specified range then it will pass the test or else it will throw the user the custom exception 
 * 
 * @author Abhishek Shandilya
 * 
 */

import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import customExceptions.OutOfPermissableRange;
import extentReports.ExtentTestManager;

public class UIandAPITemperatureComparator {
	public SoftAssert softAssertion = new SoftAssert();

	public boolean compareUIandAPITemp(int uiTemp, int apiTemp, int range) {
	if (uiTemp == apiTemp) {
		ExtentTestManager.getTest().log(Status.PASS,
				"UI Temperature is  -> " + uiTemp + " == " + " API Temperature is -> " + apiTemp);
		return uiTemp == apiTemp;
	}
	if (uiTemp > apiTemp) {
		if ((uiTemp - apiTemp) == range) {
			ExtentTestManager.getTest().log(Status.PASS,
					"UI Temperature is -> " + uiTemp + " and " + " API Temperature is -> " + apiTemp
							+ "Difference in UI Temperature and API Temperature is -> " + (uiTemp - apiTemp)
							+ " and range is " + range + " which is same as the permissable range");
		} else if((uiTemp - apiTemp) < range){
			ExtentTestManager.getTest().log(Status.PASS,
					"UI Temperature is -> " + uiTemp + " and " + " API Temperature is -> " + apiTemp
							+ "Difference in UI Temperature and API Temperature is -> " + (uiTemp - apiTemp)
							+ " and range is " + range + " which is under the permissable range");
		}else try{
			if((uiTemp - apiTemp) > range){
				throw new OutOfPermissableRange("UI Temperature is -> " + uiTemp + " and " + " API Temperature is -> " + apiTemp
						+ "Difference in UI Temperature and API Temperature is -> " + (uiTemp - apiTemp)
						+ " and range is " + range + " which is more than the permissable range");
			}
		
			}catch(OutOfPermissableRange outOfPermissableException) {
				outOfPermissableException.printStackTrace();
				ExtentTestManager.getTest().log(Status.FAIL, outOfPermissableException);
				softAssertion.assertEquals((uiTemp - apiTemp), range);
				softAssertion.assertAll();
			}
		return (uiTemp - apiTemp) < range;
	} if(uiTemp<apiTemp) {
		if ((uiTemp - apiTemp) == range) {
			ExtentTestManager.getTest().log(Status.PASS,
					"UI Temperature is -> " + uiTemp + " and " + " API Temperature is -> " + apiTemp
							+ "Difference in UI Temperature and API Temperature is -> " + (uiTemp - apiTemp)
							+ " and range is " + range + " which is same as the permissable range");
		} else try{
			if((uiTemp - apiTemp) > range){
				throw new OutOfPermissableRange("UI Temperature is -> " + uiTemp + " and " + " API Temperature is -> " + apiTemp
						+ "Difference in UI Temperature and API Temperature is -> " + (uiTemp - apiTemp)
						+ " and range is " + range + " which is more than the permissable range");
		}
		}catch(OutOfPermissableRange outOfPermissableException) {
			outOfPermissableException.printStackTrace();
			softAssertion.assertEquals((uiTemp - apiTemp), range);
			ExtentTestManager.getTest().log(Status.FAIL, outOfPermissableException);
			softAssertion.assertAll();
		}
		return (apiTemp - uiTemp) < range;
	}
	return false;
}
	
}
