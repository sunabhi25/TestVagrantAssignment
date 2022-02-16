package utilities;

/*
 * MaxTemperatureCalculation will call the comparator logic to do the compare the temperature of two source with the specified
 * range.
 * 
 *  @author Abhishek Shandilya
 * 
 */

import java.util.List;

import commonUtilities.PropertyManager;

public class MaxTemperatureCalculation {
	public static int currentTemp;
	public static int otherDayTemp;
	public static OneWeekTemperatureComparator compare =new OneWeekTemperatureComparator();
	public static int range;
	
	
	/*
	 * Method to get the next days temperature
	 * 
	 * @param List<String> temp
	 * 
	 * return the values of next days temperature
	 */
	public void nextDaysTemperature(List<String> temp) {
		PropertyManager.loadConfig();
		range = Integer.parseInt(PropertyManager.prop.getProperty("range"));
		for(int i=0; i<temp.size();i++) {
			currentTemp = Integer.parseInt(temp.get(i));
			break;
		}
		for(int i=1;i<temp.size();i++) {
			otherDayTemp = Integer.parseInt(temp.get(i));
			compare.compareTemperatureOfWeek(currentTemp, otherDayTemp, range);
		}
		
	}
}


