package com.test.automation.UiAutomation.Config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.PageFactory;

public class ReadDataFromPropertiesFile {

	public String readpropdata(String keyname) {
		File file = new File("C:\\Users\\madhav\\git\\UiAutomation\\testdata.properties");

		FileInputStream fileInput = null;

		try {
			fileInput = new FileInputStream(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();

		// load properties file
		try {
			prop.load(fileInput);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		String keyvalue = prop.getProperty(keyname);
		return keyvalue;

	}

	
	}
