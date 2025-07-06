package com.Practo.PractoAutomation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Story4 {
	
	WebDriver driver;
	
  @Test
  public void f() throws InterruptedException, AWTException {
	  WebDriverManager.chromedriver().setup();  
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.practo.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[@aria-label='Find Doctors Near You']")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Book appointment with an expert surgeon ']")).click();
		String  original = driver.getWindowHandle();
		Set<String>	allWindows = driver.getWindowHandles();
		  
			for (String windowHandle : allWindows) {
				if (!windowHandle.equals(original)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}
			
		Thread.sleep(2000);	  
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,500)"); 
		driver.findElement(By.xpath("//p[text()='Cataract']")).click();
		
		driver.findElement(By.cssSelector("#Name-AIlment-Lead-Form")).sendKeys("MAXXX");
		driver.findElement(By.id("Phone-AIlment-Lead-Form")).sendKeys("8529898709");
		driver.findElement(By.className("ailmentLeadForm-module_selectors__OzFPf")).click();
		
		Thread.sleep(5000);
		Robot robot=new Robot();
		robot.mouseMove(775,375);
		robot.delay(1000);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
//		boolean x = driver.findElement(By.cssSelector(".ailmentLeadForm-module_submit-cta__oKug8")).isEnabled();
//		System.out.println(x);		
  }
}
