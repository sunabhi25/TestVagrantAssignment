package commonUtilities;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import synchronizerHelper.Wait;

/*
 * BrowserSelectionAndAction inherits the property of BaseTest and class and allows the for the instantiation of
 * respective of browser.
 * In this class we have written two methods:-
 *  a.) browserOption
 *  b.) browserAction
 *  c.) browserClosing
 *  
 *  @author Abhishek Shandilya
 */
public class BrowserSelectionAndAction extends BaseTestUI {
	public static DesiredCapabilities capabilities = new DesiredCapabilities();
	public static ChromeOptions options = new ChromeOptions();

	/*
	 * browserOption checks and opens the browser mentioned by the user from the
	 * properties file if an invalid browser is passed then in that case it is
	 * capable of handling exception with an error message to the user.
	 * 
	 * For chrome we have provided the implementation to run in incognito mode with
	 * the option of executing the code in headless form with a default window size
	 * as 1440,600 pixel. chrome is also accepting all the ssl certificate with the
	 * help of the methods present in DesiredCapabilities class
	 */
	@SuppressWarnings("deprecation")
	public static void browserOption() {
		try {
			PropertyManager.loadConfig();
			if (PropertyManager.prop.getProperty("browser").equalsIgnoreCase("chrome")) {
				System.setProperty(chromedriver, chromepath);
				options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
				options.addArguments("--incognito");
				options.addArguments("--test-type");
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-notifications");
				options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				DesiredCapabilities dc = DesiredCapabilities.chrome();
				dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				dc.setCapability(ChromeOptions.CAPABILITY, options);
				dc.setBrowserName("chrome");
				dc.setPlatform(org.openqa.selenium.Platform.WINDOWS);
				driver = new ChromeDriver(dc);
			}
		} catch (Exception e) {
			Reporter.log("Invalid Browser Selection", true);
		}
	}

	/*
	 * browserAction method is responsible for some basic browser related operation
	 * like deleting the cookies for any hassle free execution It also call the
	 * implicit wait method from Wait class and tell the browser that some time
	 * period has been defined by the user in respective type of duration a user is
	 * interested in holding the test. The method also deals with maximizing the
	 * browser rather than a default mode execution and it is also responsible for
	 * passing the application url what so mentioned by the user from the respective
	 * Properties file.
	 * 
	 */
	public static void browserAction(int time) {
		driver.manage().deleteAllCookies();
		Wait.implicitWait();
		driver.manage().window().maximize();

		driver.get(PropertyManager.prop.getProperty("appUrl"));
	}

	/*
	 * browseClosing deals basically for closing the browser when only one tab is
	 * opened in the respective browser and quitting the browser when multiple tabs
	 * are opened during execution by selenium
	 */
	public static void browserClosing() {
		driver.close();
		driver.quit();
	}

}
