package com.test.automation.UiAutomation.ReadDataTest;

import com.test.automation.UiAutomation.UiActions.HomePage;
import com.test.automation.UiAutomation.testBase.TestBase;

import org.testng.AssertJUnit;
//import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import com.test.automation.UiAutomation.excelReader.ReadDataFromExcel;

public class TC004_ReadExcelData_With_Invalid_Credentails_And_Taking_ScreenShot extends TestBase  {

	HomePage homepagesetup;
	
	@DataProvider(name="login")
	public String[][] getdata(){
		String [][] testdata= getData("TestData.xlsx", "LoginData");
		return testdata;
	}
	
	
	
	@BeforeTest
		
	public void setup() {
		
		init();
	}

	@Test(dataProvider="login")
	public void verifyLoginWithInvalidCredentials(String email,String password) {
		log.info("==================verifyLoginWithInvalidCredentials=================");
		homepagesetup = new HomePage(driver);
		homepagesetup.loginToApplication(email,password);
		AssertJUnit.assertEquals(homepagesetup.getInvalidText(), "Authentication failed.");
		log.info("==================FinishedverifyingLoginWithInvalidCredentials=================");
		TakingScreenshots("Authentication_Error_");
	}

	@AfterClass
	public void endTest() {
		driver.close();
	}

	
	}