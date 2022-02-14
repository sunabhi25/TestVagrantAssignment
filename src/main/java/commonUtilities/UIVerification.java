package commonUtilities;

import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Level;

public class UIVerification {
	public WebDriver driver;
	public Logger logger;
	
	public UIVerification(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Method to get Logs.
	 * 
	 * @param Test Class
	 * 
	 * @return Logs for each step
	 */
	public void getLogs(Class<?> cls) {
		logger = Logger.getLogger(cls);
		PropertyConfigurator.configure("log4ji.properties");
		logger.setLevel(Level.DEBUG);
	}

}
