package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;

public class SurgeriesPage extends BasePage {

	// WebDriver driver;

	@FindBy(css = "#Name-AIlment-Lead-Form")
	WebElement namee;
	@FindBy(id = "Phone-AIlment-Lead-Form")
	WebElement phonenumber;
	@FindBy(className = "ailmentLeadForm-module_selectors__OzFPf")
	WebElement city;
	@FindBy(xpath = "//h1[text()='End to end care from Top Surgeons at our Practo Care Clinics']")
	WebElement heading;
	@FindBy(xpath = "//p[text()='Cataract']")
	WebElement surgery;
	@FindBy(css = ".ailmentLeadForm-module_submit-cta__oKug8")
	WebElement bookbtn;

//	@FindBy(xpath = "//p[@id='otpSentMsg']")
//	WebElement otpline;
	@FindBy(xpath = "//p[text()='Get FREE consultation with Practo Care surgical specialist']")
	WebElement otpline;
	
	@FindBy(xpath="//h1[text()='We are experts in Surgical solutions for 50+ ailments.']")
	WebElement scroll;   //script waits for this element to be displayed before it scrolls.

	@FindBy(xpath="(//span[normalize-space()='Select City'])[1]")
	WebElement selectcity;   //to wait for the Select City list to appear.
	
	
	public SurgeriesPage(WebDriver driver) {
		super(driver);
	}

	public void scroll() {
		 waitUntilWebElementIsVisible(scroll);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	}

	public void surgeryType() {
		surgery.click();
	}

	public void enterData(String name, String phnumber) throws InterruptedException, AWTException {
		namee.sendKeys(name);
		phonenumber.sendKeys(phnumber);
		city.click();

		Thread.sleep(2000);  //robot will not work without this wait
		//waitUntilWebElementIsVisible(selectcity);  //not working
		Robot robot = new Robot();
		robot.mouseMove(775, 375);
		robot.delay(1000);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

	}

	public void validate() throws InterruptedException {
		bookbtn.click();
		boolean condition = otpline.isDisplayed();
		System.out.println(condition);
		Assert.assertTrue(condition);

		
	}

	public int[] surgeryData(String name, String phnumber) throws IOException {

		String user[] = name.split(""); 
		String[] pass = phnumber.split(""); 
		int arr[] = new int[4];
		arr[0] = Integer.parseInt(user[0]);
		arr[1] = Integer.parseInt(user[1]);
		arr[2] = Integer.parseInt(pass[0]);
		arr[3] = Integer.parseInt(pass[1]);

		return arr;

	}

}
