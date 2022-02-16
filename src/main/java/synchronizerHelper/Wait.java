package synchronizerHelper;

/**
 * Wait class is written to handle both implicit and explicit wait condition
 * while the automation script is in progress.
 * 
 * @author abhishek shandilya
 *
 */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonUtilities.PropertyManager;
import commonUtilities.BaseTestUI;

public class Wait extends BaseTestUI {

	public static WebDriverWait wait;
	public static long time = Long.parseLong(PropertyManager.prop.getProperty("time"));
	public static long milliseconds = Long.parseLong(PropertyManager.prop.getProperty("milliseconds"));
	public static long implicitTime = Long.parseLong(PropertyManager.prop.getProperty("implicitTime"));

	public static void loadConfig() {
		PropertyManager.loadConfig();
	}

	public static void timeouts(long timeout) {
		wait = new WebDriverWait(driver, timeout);

	}

	public Wait(WebDriver driver) {
		super();
	}

	/**
	 * Method to handle implicit wait for two methods findElement and findElements
	 * 
	 * @param time to wait
	 * 
	 * @return by waiting for that particular duration for the entire test
	 */
	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(implicitTime, TimeUnit.MINUTES);
	}

	/**
	 * Method to sleep and pause for a particular moment
	 * 
	 * @param time to wait or sleep
	 * 
	 * @return by waiting for that particular duration for the particular step or
	 *         action
	 */
	public static void sleep() {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Method to handle explicit wait for all the methods including findElement and
	 * findElements
	 * 
	 * @param time to wait and element via locator value
	 * 
	 * @return by waiting till the presence of all the elements
	 */
	public static void presenceOfElementLocated(By by) {
		timeouts(time);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));

	}

	/**
	 * Method to handle explicit wait for all the methods including findElement and
	 * findElements
	 * 
	 * @param time to wait and element
	 * 
	 * @return by waiting till the element is clickable
	 */
	public static void elementToBeClickable(WebElement element) {
		timeouts(time);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

}
