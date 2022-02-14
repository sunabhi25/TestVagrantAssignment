package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import commonUtilities.GenericUtils;
import commonUtilities.UIVerification;
import extentReports.ExtentTestManager;

public class HomePage extends UIVerification {
	private static final String searchBox = "//input[@name='query']";

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void enterCityName(String cityName) {
		getLogs(this.getClass());
		logger.info("Searched city Name is " + cityName);
		ExtentTestManager.getTest().log(Status.INFO, "Searched city Name is " + cityName);
		GenericUtils.entervalueinTextbox("xpath", searchBox, cityName);
	}
}
