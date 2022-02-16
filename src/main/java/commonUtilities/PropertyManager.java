package commonUtilities;

/*
 * This class will be define the mehod of loadConfig with the help of which we can create the object of Properties class 
 * and with the help of the properties class we can read the inputs passed from the .properties files in form of key-value
 * pair.
 * 
 * @author Abhishek Shandilya
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyManager {
	public static Properties prop;

	/*
	 * This method helps to load the properties from the configuration.properties
	 * file
	 * 
	 * @param the file location of "configuration.properties"
	 */
	public static void loadConfig() {
		File file = new File("./configuration.properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(fileInput);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}
	}
}