package com.pages;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utilities.Browserfactory;
import utilities.ConfigDataProvider;
import utilities.ExcelDataProvider;
import utilities.Helper;

public class BaseClass {
public WebDriver driver;
public ConfigDataProvider config;

ExcelDataProvider Excel = new ExcelDataProvider();
public String s1 = Excel.getStringData("accept", 0, 0);
public String s2 = Excel.getStringData("accept", 0, 1);

@BeforeSuite
public void setupsuite(){
config = new ConfigDataProvider();

}

@BeforeClass
public void setup() {
	String Browser = config.getbrowser();
	String URL = config.getUrl();
	driver = Browserfactory.StartApplication(driver,Browser,URL);
	
}

@AfterClass
public void tearDown() {
	try {
		Thread.sleep(7000);
	} catch (Exception e) {
		System.out.println("Unable to open browser"+ e.getMessage());
	}
	Browserfactory.quitBrowser(driver);
}

public void teardDownMethod(ITestResult result) {
	if (result.getStatus()==ITestResult.FAILURE) {
		Helper.captureScreenshot(driver);
	}
}
}
