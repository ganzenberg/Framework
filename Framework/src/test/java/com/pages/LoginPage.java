package com.pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

WebDriver driver;
	
public LoginPage(WebDriver ldriver) {
	
this.driver = ldriver;
}

@FindBy(id="ap_email") WebElement uname;
@FindBy(id="continue") WebElement conbutton;
@FindBy(id="ap_password") WebElement pass;
@FindBy(id="signInSubmit") WebElement signbutton;
@FindBy(id="twotabsearchtextbox") WebElement search;
@FindBy(id="nav-search-submit-button") WebElement searchbar;
@FindBy(xpath="//span[text()='Apple iPhone 12 (64GB) - White']") WebElement product;
@FindBy(id="nav-global-location-popover-link") WebElement address;
@FindBy(xpath="//input[@name='IXHXS5JRUFWEBKOCIC5QG12N81ZJDQKPZA1OZPKQDJZ18N9PXTQ2EYA2OX3M7GAD:2:jkpnpomskmlq']") WebElement ch_add;
@FindBy(id="add-to-cart-button") WebElement addcart;

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
	
}

public void purchase(String mobile)
{
	search.sendKeys(mobile);
	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	searchbar.click();
	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	product.click();
	Set <String> set = driver.getWindowHandles();
	Iterator <String> itr = set.iterator();
	String Main_ID = itr.next();
	String Child_ID = itr.next();
	driver.switchTo().window(Child_ID);
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.elementToBeClickable(addcart)).click();
}
}