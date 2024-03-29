package com.pages;
import java.io.File;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import utilities.Browserfactory;
import utilities.ConfigDataProvider;
import utilities.ExcelDataProvider;
import utilities.Helper;
public class BaseClass {
public WebDriver driver;
public ConfigDataProvider config;
public ExtentReports Report;
public ExtentTest logger;
public Helper help;
ExcelDataProvider Excel = new ExcelDataProvider();
public String s1 = Excel.getStringData("accept", 0, 0);
public String s2 = Excel.getStringData("accept", 0, 1);
public String s3 = "apple12";
@BeforeSuite
public void setupsuite()
{
Reporter.log("Setting up the test", true);	
config = new ConfigDataProvider();
help = new Helper();
String date = help.getCurrentDatetime();
Report = new ExtentReports();
ExtentSparkReporter Extent = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"./Report/FreeCRM"+date+".html"));
Report.attachReporter(Extent);
Reporter.log("Test started", true);	
}

@Parameters({"browser","appUrl"})
@BeforeClass
public void setup(String Browser, String URL) {
	Reporter.log("Browser started", true);	
	//String Browser1 = config.getbrowser();
	//String URL1 = config.getUrl();
	driver = Browserfactory.StartApplication(driver,Browser,URL);
	Reporter.log("Testing in progress", true);
}

@AfterClass
public void tearDown() {
	try {
		Thread.sleep(7000);
	} catch (Exception e)
	{
		System.out.println("Unable to open browser"+ e.getMessage());
	}
	Browserfactory.quitBrowser(driver);
}

@AfterMethod
public void teardDownMethod(ITestResult result)
{
	Reporter.log("Last stage of testing", true);
	if (result.getStatus()==ITestResult.FAILURE)
	{
		logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
	}
	else if (result.getStatus()==ITestResult.SUCCESS)
	{
		logger.pass("Test passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		
	}
	else if (result.getStatus()==ITestResult.SKIP)
	{
		logger.skip("Test skipped", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		
	}
	
	Report.flush();
	Reporter.log("Testing completed", true);
}
}
