package com.test.automation.UiAutomation.custom.listner;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.test.automation.UiAutomation.testBase.TestBase;

public class Listner extends TestBase implements ITestListener {

	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
if (result.isSuccess()) {
			
			String methodName= result.getName();
			
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			// The below method will save the screen shot in d drive with name
			// "screenshot.png"
			try {

				String fileName =methodName+new Date().getTime() + ".png";

				FileUtils.copyFile(scrFile, new File("C:\\Users\\madhav\\git\\UiAutomation\\Screenshot\\" + fileName));

				Reporter.log("<a href='" + "C:\\Users\\madhav\\git\\UiAutomation\\Screenshot\\" + fileName
						+ "'> <img src='" + "C:\\Users\\madhav\\git\\UiAutomation\\Screenshot\\" + fileName
						+ "' height='100' width='100'/> </a>");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Something is wrong in try catch bloack of taking screenshots");
			}

		}

		
	}

	public void onTestFailure(ITestResult result) {

		if (!result.isSuccess()) {
			
			String methodName= result.getName();
			
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			// The below method will save the screen shot in d drive with name
			// "screenshot.png"
			try {

				String fileName =methodName+new Date().getTime() + ".png";

				FileUtils.copyFile(scrFile, new File("C:\\Users\\madhav\\git\\UiAutomation\\Screenshot\\" + fileName));

				Reporter.log("<a href='" + "C:\\Users\\madhav\\git\\UiAutomation\\Screenshot\\" + fileName
						+ "'> <img src='" + "C:\\Users\\madhav\\git\\UiAutomation\\Screenshot\\" + fileName
						+ "' height='100' width='100'/> </a>");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Something is wrong in try catch bloack of taking screenshots");
			}

		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
