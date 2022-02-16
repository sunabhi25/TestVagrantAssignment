package commonUtilities;

/*
 * This class is responsible for implementing AutoConstant as well the main use of this class is to drive the test.
 * This class will be inherited by all the Test classes in order to meet the prerequisite.
 * This class deals with different annotations of TestNG except @Test and thus makes the class as abstract.
 * Methods which will be implemented in this test are as follows:-
 *   a.) calling the method of BrowserSelectionAndAction class
 *   b.) test initialization
 *   c.) test completion
 *   
 *   @author Abhishek Shandilya
 */

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTestUI implements AutoConstant {
	public static WebDriver driver;
	public File file;
	
	/*
	 * This method is responsible for clearing the log files and clearing the execution reports before the test starts
	 */
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
	 * Method to open browser
	 * 
	 * @param wait time
	 * 
	 * @return opening of respective browser, passing of url, and providing implicit
	 * wait time to the execution.
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
