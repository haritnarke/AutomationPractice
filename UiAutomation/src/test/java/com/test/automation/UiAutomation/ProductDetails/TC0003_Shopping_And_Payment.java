package com.test.automation.UiAutomation.ProductDetails;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.test.automation.UiAutomation.UiActions.HomePage;
import com.test.automation.UiAutomation.UiActions.Shopping;
import com.test.automation.UiAutomation.UiActions.Signin;
import com.test.automation.UiAutomation.testBase.TestBase;

public class TC0003_Shopping_And_Payment extends TestBase{

	Signin signingin;
	Shopping shop;
	HomePage homepagesetup;
	@BeforeTest
		public void setup() {
		
		init();
		TakingScreenshots("Browser_Initialised_");
	}

	@Test
	public void Shopping_Payment() {
		try {
			log.info("==================verifyLoginWithInvalidCredentials=================");
			homepagesetup = new HomePage(driver);
			homepagesetup.loginToApplication(readpropdata("emailAddress"), readpropdata("passwd"));
			TakingScreenshots("Login_Done_");
			shop = new Shopping(driver);
			shop.shopping_payment();
			TakingScreenshots("Order_Confirmation_");
			homepagesetup.logout();
			TakingScreenshots("LogOut_Done_");
		} catch (Exception e) {
		 //TODO Auto-generated catch block
		TakingScreenshots("Error_");
		}
		
	}

	@AfterClass
	public void endTest() {
		driver.close();
	}

}
