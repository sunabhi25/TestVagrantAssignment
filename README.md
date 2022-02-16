AccWeather (UI and API) Test 

 

This project contains AccuWeather test folder which contains automation and api test with API used form listed at https://openweathermap.org/current  and from that we used to get current temperature   http://api.openweathermap.org/data/2.5/weather and for the UI data we used  https://www.accuweather.com/  

How to run automation suite 

Pre-requisite 

Any IDE, used Eclipse 

Java 8 

Maven 

chromedriver 

Once you install Eclipse (or any other IDE of your choice), start it. On startup go to 

Open the eclipse 

Select the folder where you have cloned the project. Click on the launch button. 

Once the eclipse is open, click on File on the top and then click on Import Project. 

Select Maven from the pop-up window and once you click on maven sub menus will get opened click on Existing maven project and then Next button will get enabled click on next button 

Select the root directory where the pom.xml is available. 

Click on pom.xml file checkbox and then click Finish button 

Once the project gets imported it will download all the necessary dependencies in your .m2 folder 

Once done the download is complete the project is ready to be used. 

Test Cases Covered 

Compare Current Temperature on the UI with the Current Temperature from the API and matches whether temperature information is same 

Compare the max Temperature of today with the upcoming week and check whether the difference is in specified range. 

Compare the max Temperature of today with the past week and check whether the difference is in specified range 

. 

Running the Test Suite 

In order to run the test first download chromedriver.exe based on your browser version and extract the downloaded driver and place the driver into the driver folder. 

From configuration.properties file you can change the “Permissiable Range” as per your need. 

 Right click on testRunner_TC_01.xml and click on Run As -> TestNG Suite. 

Results:-  

In order to see the result, go to ExecutionReport folder. 

Click on ExecutionReport  and sub menu will get open with Test-Automaton-Report.html  

Double click on the result, the detailed test result will get opened in the browser. 

 

NOTE: - In order to define the specific range, make changes in the configuration.properties file for the variable range 