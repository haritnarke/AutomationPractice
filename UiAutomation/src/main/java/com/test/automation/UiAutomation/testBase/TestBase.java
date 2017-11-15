package com.test.automation.UiAutomation.testBase;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import com.test.automation.UiAutomation.Config.ReadDataFromPropertiesFile;
import com.test.automation.UiAutomation.excelReader.ReadDataFromExcel;

public class TestBase extends ReadDataFromPropertiesFile {

	public static final Logger log = Logger.getLogger(TestBase.class.getName());

	public static WebDriver driver;
	ReadDataFromExcel excel;

	public void init() {
		selectBrowser(readpropdata("browser"));
		getUrl(readpropdata("URL"), readpropdata("browser"));
		String log = "log4j.properties";
		PropertyConfigurator.configure(log);
	}

	public void closeBrowser() {
		driver.close();

	}

	private void getUrl(String url, String browser) {
		System.out.println(url);
		driver.get(url);
		log.info("Navigating to :" + url);
		if (browser.equals("chrome")) {
			driver.manage().window().fullscreen();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	private void selectBrowser(String browser) {
		// TODO Auto-generated method stub
		if (browser.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", readpropdata("firefoxdriverpath"));
			log.info("Creating Object of " + browser);

			driver = new FirefoxDriver();
		}

		else if (browser.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", readpropdata("chromedriverpath"));
			log.info("Creating Object of " + browser);

			driver = new ChromeDriver();
		}

		else {

			System.out.println(
					"It seems you have requested for broser other than Firefox or Chrome, in such case you need to raise a support ticket with the team");
		}
	}

	public void TakingScreenshots(String FileName) {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in d drive with name
		// "screenshot.png"
		try {

			String fileName = FileName + new Date().getTime() + ".png";

			FileUtils.copyFile(scrFile, new File("C:\\Users\\madhav\\git\\UiAutomation\\Screenshot\\" + fileName));

			Reporter.log("<a href='" + "C:\\Users\\madhav\\git\\UiAutomation\\Screenshot\\" + fileName + "'> <img src='"
					+ "C:\\Users\\madhav\\git\\UiAutomation\\Screenshot\\" + fileName
					+ "' height='100' width='100'/> </a>");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Something is wrong in try catch bloack of taking screenshots");
		}
	}

	public String[][] getData(String excelName, String sheetName) {
		String path = "C:\\Users\\madhav\\eclipse-workspace\\UiAutomation\\TestData.xlsx";
		excel = new ReadDataFromExcel(path);
		String[][] data = excel.getDataFromSheet(sheetName, excelName);

		return data;

	}

	public String getCellData(String sheetName, String colName, int rowNum) {
		String path = "C:\\Users\\madhav\\eclipse-workspace\\UiAutomation\\TestData.xlsx";
		String excelName = "TestData.xlsx";
		excel = new ReadDataFromExcel(path);
		excel.getDataFromSheet(sheetName, excelName);
		String celldata = excel.getCellData(sheetName, colName, rowNum);

		return celldata;

	}

}
