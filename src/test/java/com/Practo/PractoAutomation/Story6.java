package com.Practo.PractoAutomation;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Story6 {
	//STORY 9
	
	WebDriver driver;
	
  @Test
  public void f() throws InterruptedException {
		WebDriverManager.chromedriver().setup();  
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.practo.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[@aria-label='Find Doctors Near You']")).click();
		// without thread. sleep ke scroll karne pe selenium confuse ho jaa raha hai aur homepage scroll kar
		//kar de raha hai
		
		Thread.sleep(2000);	  
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,500)"); 
		  driver.findElement(By.xpath("//span[text()='Read articles']")).click();
		  
		String  original = driver.getWindowHandle();
		Set<String>	allWindows = driver.getWindowHandles();
		  
			for (String windowHandle : allWindows) {
				if (!windowHandle.equals(original)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}
			
			  driver.findElement(By.xpath("//span[text()='Healthy Eating']")).click();
			  WebElement xxx = driver.findElement(By.linkText("3 Health Myths to Leave Behind in The New Year"));
			 
			  Assert.assertTrue(xxx.isDisplayed());
			  
			  				driver.switchTo().window(original);
			driver.findElement(By.cssSelector("#loginPhone")).sendKeys("8529898709");
			driver.findElement(By.cssSelector("#loginName")).sendKeys("MAX");
			driver.findElement(By.xpath("//button[@class='login-verify col-xs-12']")).click();
			
			//Thread.sleep(15000); //for OTP
//			
//	        WebElement sidebar = driver.findElement(By.className("sidebar-class-name")); // Update class name
//
//	        // Use JavaScript to scroll the sidebar
//	        JavascriptExecutor jjs = (JavascriptExecutor) driver;
//	        jjs.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", sidebar);
//
//			
//			driver.findElement(By.xpath("//div[text()='Payments']")).click();

  }
}
