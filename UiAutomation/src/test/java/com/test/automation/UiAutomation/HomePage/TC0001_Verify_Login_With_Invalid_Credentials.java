package com.test.automation.UiAutomation.HomePage;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.apache.log4j.Logger;

//import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;
import org.testng.annotations.*;
//import org.testng.annotations.BeforeTest;

import com.test.automation.UiAutomation.UiActions.HomePage;
import com.test.automation.UiAutomation.testBase.TestBase;

public class TC0001_Verify_Login_With_Invalid_Credentials extends TestBase {

	public static final Logger log = Logger.getLogger(TC0001_Verify_Login_With_Invalid_Credentials.class.getName());

	HomePage homepagesetup;

	@BeforeTest
	public void setup() {
		
		init();
	}

	@Test
	public void verifyLoginWithInvalidCredentials() {
		log.info("==================verifyLoginWithInvalidCredentials=================");
		homepagesetup = new HomePage(driver);
		homepagesetup.loginToApplication(readpropdata("emailAddress"), readpropdata("passwd"));
		AssertJUnit.assertEquals(homepagesetup.getInvalidText(), "Authentication failed.");
		log.info("==================FinishedverifyingLoginWithInvalidCredentials=================");
	}

	@AfterClass
	public void endTest() {
		driver.close();
	}
}
