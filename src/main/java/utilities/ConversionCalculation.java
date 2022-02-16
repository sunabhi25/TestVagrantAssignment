package utilities;

/*
 * This class is used to convert the temperature from kelvin to celsius
 * 
 * @author Abhishek Shandilya
 */

import commonUtilities.ApiUtilities;

public class ConversionCalculation {
	
	public static int temperature;
	
	/*
	 * Method to convert the kelvin to celsius
	 * 
	 * return the celsius temperature
	 */
	public static double convertKelvinToCelsius() {
		ApiUtilities utility = new ApiUtilities();
		double	celsius = utility.jsonSearchedKeyValue - 273.15;
		return celsius;
	}
	 
	/*
	 * Method to round of the temperature
	 * 
	 * return temperature
	 * 
	 */
	 public static int roundOffCelsiusTemperature() {
		temperature=(int) Math.round(ConversionCalculation.convertKelvinToCelsius());
		return temperature;
	 }	
}
