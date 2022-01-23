package com.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage {

WebDriver driver;
	
public loginPage(WebDriver ldriver) {
	
this.driver = ldriver;
}

@FindBy(id="ap_email") WebElement uname;
@FindBy(id="continue") WebElement conbutton;
@FindBy(id="ap_password") WebElement pass;
@FindBy(id="signInSubmit") WebElement signbutton;
@FindBy(id="twotabsearchtextbox") WebElement search;
@FindBy(id="nav-search-submit-button") WebElement searchbar;

public void loginToCRM(String Username,String password)
{
	try {
		Thread.sleep(3000);
	} catch (Exception e) {
		System.out.println("Unable to open browser"+ e.getMessage());
	}
	uname.sendKeys(Username);
	conbutton.click();
	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	pass.sendKeys(password);
	signbutton.click();
	search.sendKeys("Mobile phones");
	searchbar.click();
	
}

}