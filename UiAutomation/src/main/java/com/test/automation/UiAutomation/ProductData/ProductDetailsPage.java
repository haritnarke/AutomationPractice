package com.test.automation.UiAutomation.ProductData;

import java.util.List;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.test.automation.UiAutomation.testBase.TestBase;

public class ProductDetailsPage extends TestBase{

@FindBy(xpath="//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")
List<WebElement>  products;

public List<WebElement> selectproduct() {
	
	List<WebElement> elements = products;
	return elements;
}
}
