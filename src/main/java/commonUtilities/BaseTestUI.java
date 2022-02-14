package commonUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTestUI extends AutoConstant {
	public static WebDriver driver;
	protected static final Logger logger = LoggerFactory.getLogger(BaseTestUI.class);
	public File file;
	
	
	@BeforeTest
	public void clearFoldersAndFiles() throws IOException {
		file = new File("./log/application.html");
		if(file.delete()) {
			file.createNewFile();
		}
		file = new File("./log/testlog.log");
		if(file.delete()) {
			file.createNewFile();
		}
		file = new File("./testsScreenshots");
		FileUtils.deleteDirectory(file);
	}

	/*
	 * This method is used for opening the browser and entering the url as providing
	 * the implicit wait time before starting the test.It will accept one Parameter
	 * of type integer and it will implict wait is in Minute which is further linked
	 * with Wait class implicit wait method.
	 * 
	 *
	 * Method to open browser
	 * 
	 * @param wait time
	 * 
	 * @return opening of respective browser, passing of url, and providing implicit
	 * wait time to the execution.
	 *
	 * 
	 * 
	 */
	@BeforeMethod
	@Parameters({ "waitTime" })
	public void openBrowser(@Optional("10") int waitTime) throws Exception {
		BrowserSelectionAndAction.browserOption();


		BrowserSelectionAndAction.browserAction(waitTime);

	}

	
	/*
	 * The use of this method is to close the browser once the entire test suites
	 * test has been executed.
	 */
	
	  @AfterMethod public void closeBrowser() throws Exception {
	  Reporter.log("Close the test", true);
	  
	  
	  BrowserSelectionAndAction.browserClosing();
	  
	  }
	 
	

}
