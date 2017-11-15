package com.test.automation.UiAutomation.Registration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import com.test.automation.UiAutomation.Config.ReadDataFromPropertiesFile;
import com.test.automation.UiAutomation.HomePage.TC0001_Verify_Login_With_Invalid_Credentials;
import com.test.automation.UiAutomation.UiActions.HomePage;
import com.test.automation.UiAutomation.UiActions.Register;
import com.test.automation.UiAutomation.UiActions.Shopping;
import com.test.automation.UiAutomation.UiActions.Signin;
import com.test.automation.UiAutomation.testBase.TestBase;

public class TC0002_Register_And_SignIn extends TestBase {

	public static final Logger log = Logger.getLogger(TC0001_Verify_Login_With_Invalid_Credentials.class.getName());

	Register register;
	HomePage homepagesetup;
	Signin signin;
	Shopping shopping;
	ReadDataFromPropertiesFile rpd=new ReadDataFromPropertiesFile();
	
	@BeforeTest
	public void setup() {
		init();
		TakingScreenshots("Browser_Initialised_");
	}

	@Test
	public void register() {
		try {
			log.info("==================verifyLoginWithInvalidCredentials=================");
			register = new Register(driver);
			register.Signup_Using_Properties_File();
			TakingScreenshots("Sign_Up_Successful_");
			log.info("==================FinishedverifyingLoginWithInvalidCredentials=================");

			homepagesetup = new HomePage(driver);
			homepagesetup.logout();
			TakingScreenshots("Logout_Succesful_");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 
			
			signin = new Signin(driver);
			signin.login();
			
			String customername= rpd.readpropdata("customer_firstname.sendKeys")+ " " + rpd.readpropdata("customer_lastname.sendKeys");
			AssertJUnit.assertEquals(signin.getcustomername(), customername);
			log.info("==================FinishedverifyingLoginWithInvalidCredentials=================");
			TakingScreenshots("Login_Succesful_");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			TakingScreenshots("Error_");
		}
	}

	@AfterClass
	public void endTest() {
		driver.close();
	}

}
