package com.Practo.PractoAutomation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

		Thread.sleep(2000);	  
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,500)"); 
		  driver.findElement(By.xpath("//span[text()='Consult with a doctor']")).click();
		  //Thread.sleep(3000);
		  
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
			//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//h1[text()='Take Online Doctor Consultation']"))));
		  
		//  driver.findElement(By.xpath("(//a[normalize-space()='Consult Now' and contains(@class, 'link primary-button cta')])[1]")).click();
		//h1[text()='Take Online Doctor Consultation']
			Robot robot=new Robot();
			robot.mouseMove(150,570);
			robot.delay(1000);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			
			 String original = driver.getWindowHandle();
				Set<String> allWindows = driver.getWindowHandles();
				for (String windowHandle : allWindows) {
					if (!windowHandle.equals(original)) {
						driver.switchTo().window(windowHandle);
						break;
					}
				}
				
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//textarea[@placeholder='Eg: fever, headache']")).sendKeys("fever");
				driver.findElement(By.xpath("//input[@placeholder='Enter mobile number']")).sendKeys("8529898709");
				
				Thread.sleep(5000);
				
				WebElement validate = driver.findElement(By.xpath("//label[text()='Choose a relevant speciality']"));
				
				System.out.println(validate.isDisplayed());
				Assert.assertTrue(validate.isDisplayed());
  }
}
