package utilities;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browserfactory{
public WebDriver driver;
public static WebDriver StartApplication(WebDriver driver,String Browsername, String appURL) {
	
	if(Browsername.equals("Edge")){
		System.setProperty("webdriver.edge.driver","./Drivers/msedgedriver.exe");
		driver = new EdgeDriver();
		}
		else if(Browsername.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			}
		else if(Browsername.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else {
			System.out.println("we donot support this browser");
		}
	    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
		driver.get(appURL);
		driver.findElement(By.id("nav-link-accountList")).click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		return driver;
}	
public static void quitBrowser(WebDriver driver) {
	driver.quit();	
}
}
