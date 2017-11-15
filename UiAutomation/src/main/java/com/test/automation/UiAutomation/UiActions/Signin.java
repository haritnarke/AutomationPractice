package com.test.automation.UiAutomation.UiActions;

import org.apache.log4j.Logger;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.UiAutomation.Config.ReadDataFromPropertiesFile;
import com.test.automation.UiAutomation.testBase.TestBase;

public class Signin extends TestBase{

	public static final Logger log = Logger.getLogger(HomePage.class.getName());
	ReadDataFromPropertiesFile rpd= new ReadDataFromPropertiesFile();
	WebDriver driver;
	@FindBy(className="login")
	WebElement login;
	
	@FindBy(xpath="//*[@id=\"email\"]")
	WebElement email;
	
	@FindBy(xpath="//*[@id=\"passwd\"]")
	WebElement passwd;
	
	@FindBy(xpath="//*[@id=\"SubmitLogin\"]/span")
	WebElement SubmitLogin;
	
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")
	WebElement customername;
	
	
	public void login() {
		
		email.sendKeys(getCellData("RegistrationData", "RegistrationData", 6));
		passwd.sendKeys(getCellData("RegistrationData", "RegistrationData", 9));
		SubmitLogin.click();

	}

	
	public Signin(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	
	public String getcustomername() {
		log.info("Error Message is "+customername.getText());
		return customername.getText();
		
	}
	
	
}


