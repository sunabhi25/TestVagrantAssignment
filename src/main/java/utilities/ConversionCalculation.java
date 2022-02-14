package utilities;

import commonUtilities.ApiUtilities;

public class ConversionCalculation {
	
	public static int temperature;
	
	public static double convertKelvinToCelsius() {
		ApiUtilities utility = new ApiUtilities();
		double	celsius = utility.jsonSearchedKeyValue - 273.15;
		return celsius;
	}
	 
	 public static int roundOffCelsiusTemperature() {
		temperature=(int) Math.round(ConversionCalculation.convertKelvinToCelsius());
		return temperature;
	 }	
}
