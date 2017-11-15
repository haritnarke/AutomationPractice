package com.test.automation.UiAutomation.AddToCart;

import org.apache.log4j.Logger;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.UiAutomation.HomePage.TC0001_Verify_Login_With_Invalid_Credentials;
import com.test.automation.UiAutomation.UiActions.HomePage;
import com.test.automation.UiAutomation.testBase.TestBase;

public class selectProduct extends TestBase{
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
		closeBrowser();
	}

}
