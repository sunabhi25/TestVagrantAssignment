package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import commonUtilities.GenericUtils;
import commonUtilities.UIVerification;
import extentReports.ExtentTestManager;

public class SearchLocationPage extends UIVerification {
	private static final String numberOfLocation = "(//div/strong)[1]";
	private static final String searchedLocation = "(//div/strong)[2]";
	public static int totalNumberOfLocations;
	public static String nameOfLocations;
	public static String location = "(//a[contains(.,'+ nameOfLocations +')])[1]";
	public static String locationName;
	private static final String adPopUpFrame = "//*[@id='google_ads_iframe_/6581/web/in/interstitial/admin/search_0']";
	private static final String closeBtn = "//div[@id='card']//div[@id='dismiss-button']//div[@style='cursor: pointer;']//*[local-name()='svg']";

	public SearchLocationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void getTotalNumberOfLocation() {
		totalNumberOfLocations = Integer.parseInt(GenericUtils.getText("xpath", numberOfLocation));
		getLogs(this.getClass());
		logger.info("Total numer of locations after doing search with city Name is " + totalNumberOfLocations);
		ExtentTestManager.getTest().log(Status.INFO, "Total numer of locations after doing search with city Name is " + totalNumberOfLocations);
	}

	public void getNameOfSearchedLocation() {
		nameOfLocations = GenericUtils.getText("xpath", searchedLocation);
		getLogs(this.getClass());
		logger.info("Getting details of " + nameOfLocations);
		ExtentTestManager.getTest().log(Status.INFO, "Getting details of " + nameOfLocations);
	}

	public void clickOnLocations(){
		SearchLocationPage s = new SearchLocationPage(driver);
		WeatherForecastPage w = new WeatherForecastPage(driver);
		s.getTotalNumberOfLocation();
		s.getNameOfSearchedLocation();
		locationName = nameOfLocations.replaceAll("\"", "");
//		for (int i = 1; i <= totalNumberOfLocations; i++) {
			location = "(//a[contains(.,'" + locationName + "')])[1]";
			GenericUtils.clickElement("xpath", location);
			/*
			 * try { GenericUtils.clickElement("xpath", location); } catch
			 * (InterruptedException e) { System.out.println("Element not clickable");
			 * e.printStackTrace(); }
			 */
			if (driver.getCurrentUrl().contains("search-locations")) {
//				Thread.sleep(2000);
				GenericUtils.frameByWebElement("xpath", adPopUpFrame);
				GenericUtils.clickElement("xpath", closeBtn);
//				Thread.sleep(1000);
				w.currentWeatherListDetails();

			} else {
				w.currentWeatherListDetails();
			}
//			driver.navigate().back();
//			Thread.sleep(1000);

//		}

	}
}
