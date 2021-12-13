package com.testcases;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.pages.BaseClass;
import com.pages.loginPage;

public class Testcase1 extends BaseClass {

@Test
public void loginApp()
{
	logger = Report.createTest("Login to Application");
	loginPage login = PageFactory.initElements(driver, loginPage.class);
	
	login.loginToCRM(s1,s2);
}
}
