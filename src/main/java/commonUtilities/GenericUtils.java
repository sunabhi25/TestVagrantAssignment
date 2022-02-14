package commonUtilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import synchronizerHelper.Wait;

public class GenericUtils extends BaseTestUI {

	public static WebElement element;
	public static List<WebElement> elements;
	
	public GenericUtils(WebDriver driver) {
		super();
	}

	/**
	 * Method to get the element from the UI
	 * 
	 * @param lcocator type , locator value
	 */
	public static WebElement getElement(String locatorType, String locatorValue) {
		try {
			if (locatorType.equalsIgnoreCase("id")) {
				Wait.presenceOfElementLocated(By.id(locatorValue));
				element = driver.findElement(By.id(locatorValue));
				return element;
			} else if (locatorType.equalsIgnoreCase("tag") || locatorType.equalsIgnoreCase("tagName")) {
				Wait.presenceOfElementLocated(By.tagName(locatorValue));
				element = driver.findElement(By.tagName(locatorValue));
				return element;
			} else if (locatorType.equalsIgnoreCase("name")) {
				Wait.presenceOfElementLocated(By.name(locatorValue));
				element = driver.findElement(By.name(locatorValue));
				return element;
			} else if (locatorType.equalsIgnoreCase("classname")) {
				Wait.presenceOfElementLocated(By.className(locatorValue));
				element = driver.findElement(By.className(locatorValue));
				return element;
			} else if (locatorType.equalsIgnoreCase("cssSelector")) {
				Wait.presenceOfElementLocated(By.cssSelector(locatorValue));
				element = driver.findElement(By.cssSelector(locatorValue));
				return element;

			} else if (locatorType.equalsIgnoreCase("linkText")) {
				Wait.presenceOfElementLocated(By.linkText(locatorValue));
				element = driver.findElement(By.linkText(locatorValue));
				return element;

			} else if (locatorType.equalsIgnoreCase("partialLinkText")) {
				Wait.presenceOfElementLocated(By.partialLinkText(locatorValue));
				element = driver.findElement(By.partialLinkText(locatorValue));
				return element;
			} else if (locatorType.equalsIgnoreCase("xpath")) {
				Wait.presenceOfElementLocated(By.xpath(locatorValue));
				element = driver.findElement(By.xpath(locatorValue));
				return element;
			} else {
				Reporter.log("Sorry, No Matches found. Please check arguments passed", true);
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	/*
	 * public static List<WebElement> getElements(String locatorType, String
	 * locatorValue) { try { if (locatorType.equalsIgnoreCase("id")) {
	 * Wait.presenceOfElementLocated(By.id(locatorValue)); elements =
	 * driver.findElements(By.id(locatorValue)); return elements; } else if
	 * (locatorType.equalsIgnoreCase("tag") ||
	 * locatorType.equalsIgnoreCase("tagName")) {
	 * Wait.presenceOfElementLocated(By.tagName(locatorValue)); elements =
	 * driver.findElements(By.tagName(locatorValue)); return elements; } else if
	 * (locatorType.equalsIgnoreCase("name")) {
	 * Wait.presenceOfElementLocated(By.name(locatorValue)); elements =
	 * driver.findElements(By.name(locatorValue)); return elements; } else if
	 * (locatorType.equalsIgnoreCase("classname")) {
	 * Wait.presenceOfElementLocated(By.className(locatorValue)); elements =
	 * driver.findElements(By.className(locatorValue)); return elements; } else if
	 * (locatorType.equalsIgnoreCase("cssSelector")) {
	 * Wait.presenceOfElementLocated(By.cssSelector(locatorValue)); elements =
	 * driver.findElements(By.cssSelector(locatorValue)); return elements;
	 * 
	 * } else if (locatorType.equalsIgnoreCase("linkText")) {
	 * Wait.presenceOfElementLocated(By.linkText(locatorValue)); elements =
	 * driver.findElements(By.linkText(locatorValue)); return elements;
	 * 
	 * } else if (locatorType.equalsIgnoreCase("partialLinkText")) {
	 * Wait.presenceOfElementLocated(By.partialLinkText(locatorValue)); elements =
	 * driver.findElements(By.partialLinkText(locatorValue)); return elements; }
	 * else if (locatorType.equalsIgnoreCase("xpath")) {
	 * Wait.presenceOfElementLocated(By.xpath(locatorValue)); elements =
	 * driver.findElements(By.xpath(locatorValue)); return elements; } else {
	 * Reporter.log("Sorry, No Matches found. Please check arguments passed", true);
	 * return null; } } catch (Exception e) { e.printStackTrace(); } return
	 * elements; }
	 */
	
	

	/**
	 * Method to click on the element
	 * 
	 * @param lcocator type , locator value
	 * @throws InterruptedException 
	 */
	public static void clickElement(String locatorType, String locatorValue){
		getElement(locatorType, locatorValue);
		Wait.elementToBeClickable(element);
		element.click();
	}

	/**
	 * Method to enter the value in the text
	 * 
	 * @param lcocator type , locator value , value
	 */
	public static void entervalueinTextbox(String locatorType, String locatorValue, String textBoxValue) {
		GenericUtils.getElement(locatorType, locatorValue);
		if (GenericUtils.getElement(locatorType, locatorValue).getText() != null) {
			GenericUtils.getElement(locatorType, locatorValue).clear();
			element.sendKeys(textBoxValue,Keys.ENTER);
		} else {
			element.sendKeys(textBoxValue,Keys.ENTER);
		}
	}

	public static String getText(String locatorType, String locatorValue) {
		GenericUtils.getElement(locatorType, locatorValue);
		getElement(locatorType, locatorValue);
		return element.getText();
	}
	
	

	public static boolean isDisplayed(String locatorType, String locatorValue) {
		getElement(locatorType, locatorValue);
		return element.isDisplayed();
	}
	
	
	/**
	 * Method to handles frames present by switching on the frame
	 * 
	 * @param WebElement present on the webpage
	 */
	public static void frameByWebElement(String locatorType, String locatorValue) {
		 driver.switchTo().frame(getElement(locatorType, locatorValue));
	}
	
	/**
	 * Method to switch from frames to webpage.
	 */
	public static void defaultFrame() {
		driver.switchTo().defaultContent();
	}
}
