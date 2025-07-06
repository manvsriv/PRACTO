package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.parameters.PropertyFileReader;

public class SkinCarePage extends BasePage{
	
	WebDriver driver;
	PropertyFileReader fileReader;
	
	@FindBy(xpath="//div[text()='Surgeries']") 
	WebElement surgeries;
	
	//WebElement patientName=driver.findElement(By.name(fileReader.getProperty("name")));
	@FindBy(name="name")
	WebElement patientName;
	
	@FindBy(name="mobileInteraction")
	WebElement phoneNumber;

	public SkinCarePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		fileReader=new PropertyFileReader("C:\\Users\\SDHINDLE\\Desktop\\PRACTO\\Sprint\\PractoTesting\\src\\test\\resource\\PropertieFile\\Data.properties");
	}
	
	public void clickOnRelatedQuetions() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		 
		Robot robot;
		try {
			robot = new Robot();
			robot.mouseMove(1000,400);
			robot.delay(1000);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		} catch (AWTException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void clickOnTroubles() throws InterruptedException {
		
		waitUntilWebElementIsVisible(surgeries);
		
		String originalWindow = driver.getWindowHandle();
		 
	    // Wait for new window to open
	    Set<String> allWindows = driver.getWindowHandles();
	    for (String windowHandle : allWindows) {
	        if (!windowHandle.equals(originalWindow)) {
	            driver.switchTo().window(windowHandle);
	            break;
	        }
	    }
	    JavascriptExecutor js = (JavascriptExecutor) driver; 
	    js.executeScript("window.scrollBy(0,1200)");
	    
	    Robot robot;
		try {
			robot = new Robot();
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		} catch (AWTException e) {
			
			e.printStackTrace();
		}
	    		
	}
	
	public void enterPatientName() {
		waitUntilWebElementIsVisible(patientName);
		waitUntilWebElementIsClickable(patientName);
		patientName.sendKeys(fileReader.getProperty("name"));
	}
	
	public void enterPhoneNumber() {
		waitUntilWebElementIsVisible(phoneNumber);
		waitUntilWebElementIsClickable(phoneNumber);
		phoneNumber.sendKeys(fileReader.getProperty("contactNumber"));
	}
	
	public void clickContinue() {
		Robot robot;
		try {
			robot = new Robot();
			robot.mouseMove(220,620);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(25000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void onPaymentPage() {
		Assert.assertTrue(driver.getCurrentUrl().equals("https://www.practo.com/consult/direct/payment"), "Payment Page not visible");
	}
}
