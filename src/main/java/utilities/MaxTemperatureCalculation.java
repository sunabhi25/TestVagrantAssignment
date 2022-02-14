package utilities;

import java.util.List;

public class MaxTemperatureCalculation {
	public static int currentTemp;
	public static int otherDayTemp;
	public static OneWeekTemperatureComparator compare =new OneWeekTemperatureComparator();
	
	public void nextDaysTemperature(List<String> temp) {
		for(int i=0; i<temp.size();i++) {
			currentTemp = Integer.parseInt(temp.get(i));
			break;
		}
		for(int i=1;i<temp.size();i++) {
			otherDayTemp = Integer.parseInt(temp.get(i));
			compare.compareTemperatureOfWeek(currentTemp, otherDayTemp, 2);
			System.out.println(compare.compareTemperatureOfWeek(currentTemp, otherDayTemp, 2));
		}
		
	}
}


