package commonUtilities;

/*
 * UIVerification  will be inherited by all the POM classes as this class will have some functionality  logging for each and every action done by 
 * the user as it will be calling loggers to log the actions for each and every line of codes and it will also be helpful for 
 * debugging our execution when so required.
 * 
 * @author Abhishek Shandilya
 */

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
