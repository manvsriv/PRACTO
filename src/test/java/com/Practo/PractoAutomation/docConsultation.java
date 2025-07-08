package com.Practo.PractoAutomation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class docConsultation {
  @Test
  public void f() throws InterruptedException, AWTException {
	  
		WebDriverManager.chromedriver().setup();  
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.practo.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[@aria-label='Find Doctors Near You']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Pediatrician']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[3]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='20+ Years of experience']")).click();

		Thread.sleep(2000);	  
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,500)"); 
		  
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[4]/div/div[1]/div/div[3]/div[1]/div/div[2]/div/div/div[2]/div[1]/button")).click();
		
		  Thread.sleep(3000);
		  
			Robot robot=new Robot();
			robot.mouseMove(200,625);
			robot.delay(1000);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			
			Thread.sleep(2000);			
			driver.findElement(By.xpath("//input[@placeholder='Mobile Number']")).sendKeys("7307325021");
			driver.findElement(By.cssSelector(".c-btn--dark")).click();

			Thread.sleep(20000);
			driver.findElement(By.xpath("//label[text()='Someone Else']")).click();
			//driver.findElement(By.xpath("//input[@placeholder='']")).clear();
			Thread.sleep(2000);
			
			Actions action = new Actions(driver);
			
			action.sendKeys(Keys.TAB).sendKeys("Maxxx").build().perform();
			action.sendKeys(Keys.TAB).sendKeys("7307325021").build().perform();
			action.sendKeys(Keys.TAB).build().perform();
			action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
			
			
			
			
			
			
			
			
			
			
//			
//			driver.findElement(By.xpath("//input[@placeholder='Enter Patient's Full Name']")).sendKeys("MAXXXXX");
//		Thread.sleep(2000);
//			driver.findElement(By.xpath("//input[@placeholder='Enter Patient's Mobile Number']")).sendKeys("8529898709");
//            		
//			Thread.sleep(2000);	  
//			  JavascriptExecutor jts = (JavascriptExecutor) driver;
//			  jts.executeScript("window.scrollBy(0,500)"); 
//			  
//			  driver.findElement(By.cssSelector(".c-btn--dark")).click();
		
			  
		
//			//input[@placeholder='Mobile Number']   ph number
//			.c-btn--dark   button
//			//input[@placeholder='Enter Your Full Name']   name
//			.c-btn--dark  button
		
			Thread.sleep(5000);
		   boolean validate = driver.findElement(By.xpath("//div[text()='We will send you an SMS and email with the appointment and practice details']")).isDisplayed();
		   System.out.println(validate);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		Thread.sleep(2000);	  
//		  JavascriptExecutor js = (JavascriptExecutor) driver;
//		  js.executeScript("window.scrollBy(0,500)"); 
//		  driver.findElement(By.xpath("//span[text()='Consult with a doctor']")).click();
//		  //Thread.sleep(3000);
		  
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
			//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//h1[text()='Take Online Doctor Consultation']"))));
		  
		//  driver.findElement(By.xpath("(//a[normalize-space()='Consult Now' and contains(@class, 'link primary-button cta')])[1]")).click();
		//h1[text()='Take Online Doctor Consultation']
//			Robot robot=new Robot();
//			robot.mouseMove(150,570);
//			robot.delay(1000);
//			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//			
//			 String original = driver.getWindowHandle();
//				Set<String> allWindows = driver.getWindowHandles();
//				for (String windowHandle : allWindows) {
//					if (!windowHandle.equals(original)) {
//						driver.switchTo().window(windowHandle);
//						break;
//					}
//				}
//				
//				Thread.sleep(5000);
//				
//				driver.findElement(By.xpath("//textarea[@placeholder='Eg: fever, headache']")).sendKeys("fever");
//				driver.findElement(By.xpath("//input[@placeholder='Enter mobile number']")).sendKeys("8529898709");
//				
//				Thread.sleep(5000);
//				
//				WebElement validate = driver.findElement(By.xpath("//label[text()='Choose a relevant speciality']"));
//				
//				System.out.println(validate.isDisplayed());
//				Assert.assertTrue(validate.isDisplayed());
  }
}
