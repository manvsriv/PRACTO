package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PediatricianPage extends BasePage{
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[3]")
	WebElement Experience;
	
	@FindBy(xpath="//span[text()='20+ Years of experience']")
	WebElement twentyplus;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[4]/div/div[1]/div/div[3]/div[1]/div/div[2]/div/div/div[2]/div[1]/button")
	WebElement bookvisit;
	
	@FindBy(xpath="//input[@placeholder='Mobile Number']")
	WebElement otpnumber;
	
	@FindBy(css=".c-btn--dark")
	WebElement otpbutton;
	
	public PediatricianPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	public void selectExperience()
	{

	    waitUntilWebElementIsClickable(Experience);
		Experience.click();
		waitUntilWebElementIsClickable(twentyplus);
		twentyplus.click();
	}
	public void bookClinicVisit()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	  
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,500)"); 
		  waitUntilWebElementIsClickable(bookvisit);
		  bookvisit.click();
		  
		  try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
			Robot robot = null;
			try {
				robot = new Robot();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			robot.mouseMove(200,625);
			robot.delay(1000);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		  
	}
	
	public void enterOTP()
	{
		waitUntilWebElementIsVisible(otpnumber);
		otpnumber.sendKeys("7307325021");
		otpbutton.click();
		try {
			Thread.sleep(25000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
