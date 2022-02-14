package utilities;

import com.aventstack.extentreports.Status;

import extentReports.ExtentTestManager;

public class UIandAPITemperatureComparator {

	public boolean compareUIandAPITemp(int uiTemp, int apiTemp, int range) {
		
		if(uiTemp == apiTemp) {
			ExtentTestManager.getTest().log(Status.INFO, "UI Temperature is  -> "+ uiTemp +" == " + " API Temperature is -> " + apiTemp);
			return uiTemp == apiTemp;
		}	if(uiTemp > apiTemp) {
			ExtentTestManager.getTest().log(Status.INFO, "UI Temperature is -> "+ uiTemp +" and " + " API Temperature is -> " + apiTemp  + "Difference in UI Temperature and API Temperature is -> " + (uiTemp - apiTemp) + " > " + range);
			return (uiTemp-apiTemp) < range;
		}else {
			ExtentTestManager.getTest().log(Status.INFO, "UI Temperature is -> "+ uiTemp +" and " + " API Temperature is -> " + apiTemp  + "Difference in API Temperature and API Temperature is -> " + (apiTemp - uiTemp) + " > " + range);
			return (apiTemp-uiTemp) <range; 
		}
	}
}
