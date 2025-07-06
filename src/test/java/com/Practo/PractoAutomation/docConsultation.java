package com.Practo.PractoAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class docConsultation {
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
		  driver.findElement(By.xpath("//span[text()='Consult with a doctor']")).click();
	  
  }
}
