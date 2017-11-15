package com.test.automation.UiAutomation.UiActions;


import org.apache.log4j.Logger;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public static final Logger log = Logger.getLogger(HomePage.class.getName());
	
		
	
	@FindBy(className = "login")
	WebElement signIN;

	@FindBy(id = "email")
	WebElement loginEmailAddress;

	@FindBy(id = "passwd")
	WebElement loginPassword;

	@FindBy(id = "SubmitLogin")
	WebElement submitButton;

	@FindBy(xpath = "//*[@id='center_column']/div[1]/ol/li")
	WebElement authenticationFailed;

	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
	WebElement logout;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void loginToApplication(String emailAddress, String passwd) {
		
		log.info("Signing in");
		//driver.findElement(By.className(rpd.readpropdata("LOGIN"))).click();
		signIN.click();
		loginEmailAddress.sendKeys(emailAddress);
		loginPassword.sendKeys(passwd);
		submitButton.click();
		log.info("Clicked Successfuly");
	}

	public void logout() {

		logout.click();

	}

	public String getInvalidText() {
		log.info("Error Message is " + authenticationFailed.getText());
		return authenticationFailed.getText();

	}
}
