package com.Practo.PractoAutomation;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Story8 {
	
	WebDriver driver;
	WebDriverWait wait;
  @Test
  public void f() throws InterruptedException {
	  
		WebDriverManager.chromedriver().setup();  
		WebDriver driver = new ChromeDriver();
	     driver.get("https://www.practo.com/");
		//driver.get("https://drive.practo.com/appointments");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[@aria-label='Find Doctors Near You']")).click();
		
		// without thread. sleep ke scroll karne pe selenium confuse ho jaa raha hai aur homepage scroll kar
		//kar de raha hai
		
		Thread.sleep(2000);	  
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,500)"); 
		  driver.findElement(By.xpath("//span[text()='View medical records']")).click();
		  
		String  original = driver.getWindowHandle();
		Set<String>	allWindows = driver.getWindowHandles();
		  
			for (String windowHandle : allWindows) {
				if (!windowHandle.equals(original)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}
			
			driver.findElement(By.cssSelector("#loginPhone")).sendKeys("8529898709");
			driver.findElement(By.cssSelector("#loginName")).sendKeys("MAX");
			driver.findElement(By.xpath("//button[@class='login-verify col-xs-12']")).click();
			
			Thread.sleep(20000); //for OTP
			
     		driver.findElement(By.xpath("//div[text()='Appointments']")).click();
//			//driver.findElement(By.xpath("//div[@id='rebookBtnc06f31dd07f14c84a15c2bb5a12d7b76']")).click();

     		WebElement year = driver.findElement(By.xpath("//div[text()='2025']"));
          WebDriverWait 	wait = new WebDriverWait(driver, Duration.ofSeconds(5));
  		wait.until(ExpectedConditions.visibilityOf(year));
  		
 		WebElement btn = driver.findElement(By.xpath("(//div[starts-with(@id, 'rebookBtn') and text()='Book again'])[1]"));

 		btn.click();
			
		
		   
//			Actions action = new Actions(driver);
//			wait = new WebDriverWait(driver, Duration.ofSeconds(8));
//			wait.until(ExpectedConditions.elementToBeClickable(btn));
//			//Single Click
//			action.moveToElement(btn).click().build().perform();  
  }
  
//*[@id="rebookBtnc06f31dd07f14c84a15c2bb5a12d7b76"]
  
}
