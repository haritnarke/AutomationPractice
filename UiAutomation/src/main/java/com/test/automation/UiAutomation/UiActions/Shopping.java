package com.test.automation.UiAutomation.UiActions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.automation.UiAutomation.testBase.TestBase;

public class Shopping extends TestBase{

	public WebDriver driver;
	
	TestBase tb=new TestBase();
	
	public Shopping(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void shopping_payment() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("1");
	
		System.out.println("2");
		// driver.findElement(By.cssSelector("a[href*='http://automationpractice.com/index.php?id_category=5&controller=category']")).click();
		driver.findElement(By.xpath(".//*[@id='block_top_menu']/ul/li[3]/a")).click();
		System.out.println("3");
		WebElement link = driver.findElement(By.xpath(".//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img"));
		System.out.println("4");
		// System.out.println("Above mousehover is been performed");
		Actions builder = new Actions(driver);
		System.out.println("5");

		System.out.println("Above mousehover is been performed 1");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,700)", "");
		builder.moveToElement(link).build().perform();
		// builder.moveToElement(link, 13655, 655).build().perform();

		System.out.println("Above mousehover is been performed");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement addtocart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span")));
		System.out.println("Element found");
		addtocart.click();
		//TakingScreenshots("Added_to_cart");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		System.out.println("Added to cart now we need to checkout");

		driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")).click();

		System.out.println("Proceede to checkout");
		driver.findElement(By.xpath(".//*[@id='center_column']/p[2]/a[1]/span")).click();
		//TakingScreenshots("1_");
		driver.findElement(By.xpath(".//*[@id='center_column']/form/p/button")).click();
		//TakingScreenshots("2_");
		driver.findElement(By.xpath(".//*[@id='cgv']")).click();
		//TakingScreenshots("3_");
		driver.findElement(By.xpath(".//*[@id='form']/p/button")).click();
		//TakingScreenshots("4_");
		driver.findElement(By.xpath(".//*[@id='HOOK_PAYMENT']/div[1]/div/p/a")).click();
		//TakingScreenshots("5_");
		
		
		driver.findElement(By.xpath(".//*[@id='cart_navigation']/button")).click();
		
		jse.executeScript("window.scrollBy(0,289)", "");
		
		

	}

}
