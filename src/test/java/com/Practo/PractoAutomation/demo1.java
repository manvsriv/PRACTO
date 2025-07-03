package com.Practo.PractoAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demo1 {
	
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  
	  WebDriverManager.edgedriver().setup();
	  driver = new EdgeDriver();
	  driver.get("https://www.practo.com/");
	  driver.manage().window().maximize();
	  
//	  Thread.sleep(2000);	  
//	  JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
//		javaScriptExecutor.executeScript("window.scroll(0,400)");
	  //scrolling kaam kar rhi hai
	  driver.findElement(By.xpath("//a[@aria-label='Find Doctors Near You']")).click();
	  
	  Thread.sleep(2000);
	  
	  WebElement dropdown = driver.findElement(By.xpath("//span[text()='Security & help']"));
	  dropdown.click();
	  
	  WebElement Help = driver.findElement(By.xpath("//span[text()='Help']"));
		
		Actions action = new Actions(driver);
		
		//Single Click
		action.moveToElement(Help).click().build().perform();  
		
		WebElement casestd= driver.findElement(By.xpath("//a[@title='View all posts in Practo Case Studies']"));
		action.click(casestd).build().perform();
		
		driver.findElement(By.xpath("//a[text()='Prime Case Studies']")).click();
		
		WebElement firstcase = driver.findElement(By.xpath("//a[text()='Empowering patient experience with digital healthcare']"));
		
		Assert.assertTrue(firstcase.isDisplayed());

  }
}
