package com.testcases;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.pages.BaseClass;
import com.pages.LoginPage;

public class Testcase1 extends BaseClass {

//Test 1
@Test
public void loginApp()
{
	logger = Report.createTest("Login to Application");
	LoginPage login = PageFactory.initElements(driver, LoginPage.class);
	login.loginToCRM(s1,s2);
}

//Test 2
@Test
public void productOrder()
{
	logger = Report.createTest("Add product");
	LoginPage AddToCart = PageFactory.initElements(driver, LoginPage.class);
	AddToCart.purchase(s3);	
}
}

