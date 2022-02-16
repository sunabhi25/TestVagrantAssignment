package commonUtilities;

/*
 * AutoConstant interface is used to store all the final values which will remain constant through out the test
 * 
 * @author Abhishek Shandilya
 */

public interface AutoConstant {
	public static final String url = "http://api.openweathermap.org/";
	public static final String resource = "data/2.5/weather";
	public static final String token_key = "appid";
	public static final String token_value = "7fe67bf08c80ded756e598d6f8fedaea";
	public static final String cityName_key ="q";
	public static final String cityName_value = "Patna, Bihar";
	
	public static final String chromedriver = "webdriver.chrome.driver";
	public static final String chromepath = "./drivers/chromedriver.exe";
}
