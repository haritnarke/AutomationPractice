package com.test.automation.UiAutomation.UiActions;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import com.test.automation.UiAutomation.Config.ReadDataFromPropertiesFile;
import com.test.automation.UiAutomation.testBase.TestBase;
public class Register extends TestBase {
	
	public static final Logger log = Logger.getLogger(HomePage.class.getName());
	
	WebDriver driver;
	
	ReadDataFromPropertiesFile rpd = new ReadDataFromPropertiesFile();
	@FindBy(className = "login")
	WebElement login;

	@FindBy(id = "email_create")
	WebElement email_create;

	@FindBy(id = "SubmitCreate")
	WebElement SubmitCreate;

	@FindBy(xpath = "//input[@name='id_gender' and @type='radio' and @id='id_gender1']")
	WebElement Title;

	@FindBy(id = "customer_firstname")
	WebElement customer_firstname;

	@FindBy(id = "customer_lastname")
	WebElement customer_lastname;

	@FindBy(id = "passwd")
	WebElement passwd;

	@FindBy(id = "days")
	WebElement days;

	@FindBy(id = "months")
	WebElement months;

	@FindBy(id = "years")
	WebElement years;

	@FindBy(xpath = "//input[@id='newsletter']")
	WebElement newsletter;

	@FindBy(xpath = "//input[@id='optin']")
	WebElement optin;

	@FindBy(id = "company")
	WebElement company;

	@FindBy(id = "address1")
	WebElement address1;

	@FindBy(id = "address2")
	WebElement address2;

	@FindBy(id = "city")
	WebElement city;

	@FindBy(id = "id_state")
	WebElement idstate;

	@FindBy(id = "postcode")
	WebElement postcode;

	@FindBy(id = "id_country")
	WebElement id_country;

	@FindBy(id = "other")
	WebElement other;

	@FindBy(id = "phone_mobile")
	WebElement phone_mobile;

	@FindBy(id = "alias")
	WebElement alias;

	@FindBy(id = "submitAccount")
	WebElement submitAccount;

	@FindBy(xpath = "//*[@id='create_account_error']/ol/li")
	WebElement Failuremessage;

	public Register(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void Signup_Using_Properties_File() {
		try {
			String s1=getCellData("RegistrationData", "RegistrationData", 2);
			System.out.println(s1);
			log.info("Signing in");
			login.click();
			// System.out.println(rpd.readpropdata("email_create.sendKeys"));
			email_create.sendKeys(rpd.readpropdata("email_create.sendKeys"));
			SubmitCreate.click();
			Title.click();
			customer_firstname.sendKeys(rpd.readpropdata("customer_firstname.sendKeys"));
			customer_lastname.sendKeys(rpd.readpropdata("customer_lastname.sendKeys"));
			passwd.sendKeys(rpd.readpropdata("passwd.sendKeys"));

			Select Days = new Select(days);
			Days.selectByValue(rpd.readpropdata("Days.selectByValue"));

			Select Months = new Select(months);
			Months.selectByValue(rpd.readpropdata("Months.selectByValue"));

			Select Years = new Select(years);
			Years.selectByValue(rpd.readpropdata("Years.selectByValue"));

			newsletter.click();
			optin.click();
			company.sendKeys(rpd.readpropdata("company.sendKeys"));
			address1.sendKeys(rpd.readpropdata("address1.sendKeys"));
			address2.sendKeys(rpd.readpropdata("address2.sendKeys"));
			city.sendKeys(rpd.readpropdata("city.sendKeys"));

			Select id_state = new Select(idstate);
			id_state.selectByValue(rpd.readpropdata("id_state.selectByValue"));

			postcode.sendKeys(rpd.readpropdata("postcode.sendKeys"));

			Select idcountry = new Select(id_country);
			idcountry.selectByValue(rpd.readpropdata("idcountry.selectByValue"));

			other.sendKeys(rpd.readpropdata("other.sendKeys"));
			phone_mobile.sendKeys(rpd.readpropdata("phone_mobile.sendKeys"));
			alias.clear();
			alias.sendKeys("Home");
			submitAccount.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("We are in exception loop for Registration");
			AssertJUnit.assertEquals(Failuremessage.getText(),
					"An account using this email address has already been registered. Please enter a valid password or request a new one.");
		}

	}

	public void Signup_Using_Data_From_Excel() {
		//try {
			String s1=getCellData("RegistrationData", "RegistrationData", 10);
			System.out.println(s1);
			log.info("Signing in");
			login.click();
			// System.out.println(rpd.readpropdata("email_create.sendKeys"));
			email_create.sendKeys(getCellData("RegistrationData", "RegistrationData", 6));
			SubmitCreate.click();
			Title.click();
			customer_firstname.sendKeys(getCellData("RegistrationData", "RegistrationData", 7));
			customer_lastname.sendKeys(getCellData("RegistrationData", "RegistrationData", 8));
			passwd.sendKeys(getCellData("RegistrationData", "RegistrationData", 9));

			Select Days = new Select(days);
			Days.selectByValue(getCellData("RegistrationData", "RegistrationData", 10));

			Select Months = new Select(months);
			Months.selectByValue(getCellData("RegistrationData", "RegistrationData", 11));

			Select Years = new Select(years);
			Years.selectByValue(getCellData("RegistrationData", "RegistrationData", 12));

			newsletter.click();
			optin.click();
			company.sendKeys(getCellData("RegistrationData", "RegistrationData", 13));
			address1.sendKeys(getCellData("RegistrationData", "RegistrationData", 14));
			address2.sendKeys(getCellData("RegistrationData", "RegistrationData", 15));
			city.sendKeys(getCellData("RegistrationData", "RegistrationData", 16));

			Select id_state = new Select(idstate);
			id_state.selectByValue(getCellData("RegistrationData", "RegistrationData", 17));

			postcode.sendKeys(getCellData("RegistrationData", "RegistrationData", 18));

			Select idcountry = new Select(id_country);
			idcountry.selectByValue(getCellData("RegistrationData", "RegistrationData", 19));
			
			other.sendKeys(getCellData("RegistrationData", "RegistrationData", 20));
			phone_mobile.sendKeys(getCellData("RegistrationData", "RegistrationData", 21));
			alias.clear();
			alias.sendKeys("Home");
			submitAccount.click();
		//} catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println("We are in exception loop for Registration");
			//AssertJUnit.assertEquals(Failuremessage.getText(),
				//	"An account using this email address has already been registered. Please enter a valid password or request a new one.");
		//}

	}

}
