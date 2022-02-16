package screenShots;

/*
 * This class is responsible for taking the screenshot for taking the screenshot used TakeScreenhot Interface
 * 
 * @author Abhishek Shandilya
 * 
 */

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ExtentReportScreenshots {

	/*
	 * Method to take the screenshot
	 * 
	 * @param WebDriver and ScreenshotName
	 * 
	 * @return the destination of the screenshot saved
	 */
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/testsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
}
