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

public class SurgeriesPage extends BasePage{
	
	//WebDriver driver;
	
	@FindBy(css="#Name-AIlment-Lead-Form")
	WebElement namee;
	@FindBy(id="Phone-AIlment-Lead-Form")
	WebElement phonenumber;
	@FindBy(className="ailmentLeadForm-module_selectors__OzFPf")
	WebElement city;
	@FindBy(xpath="//h1[text()='End to end care from Top Surgeons at our Practo Care Clinics']")
	WebElement heading;
	@FindBy(xpath="//p[text()='Cataract']")
	WebElement surgery;
	@FindBy(css=".ailmentLeadForm-module_submit-cta__oKug8")
	WebElement bookbtn;
	
	@FindBy(xpath="//p[@id='otpSentMsg']")
	WebElement otpline;
	
	public SurgeriesPage(WebDriver driver)
	{
		super(driver);
	}
	
	public void scroll() throws InterruptedException
	{
		//waitUntilWebElementIsVisible(heading);
		Thread.sleep(5000);
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,500)"); 
	}
	
	public void surgeryType()
	{
		surgery.click();
	}
	
	public void enterData(String name, String phnumber) throws InterruptedException, AWTException
	{
		namee.sendKeys(name);
		phonenumber.sendKeys(phnumber);
		city.click();
		
		Thread.sleep(5000);
		Robot robot=new Robot();
		robot.mouseMove(775,375);
		robot.delay(1000);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
	}
	
	public void validate() throws InterruptedException
	{
	
//		boolean condition=isElementClickable(bookbtn);
//		System.out.println(condition);
		
		bookbtn.click();
		Thread.sleep(5000);
		System.out.println(otpline.isDisplayed());
		Assert.assertTrue(otpline.isDisplayed());
	}
	
	public void provideData(int[]arr) throws IOException, InterruptedException, AWTException
	{
		String path = "C:\\Users\\manvsriv\\Practo\\PractoAutomation\\src\\test\\resource\\ExcelData\\PractoCred1.xlsx";

	
	FileInputStream fis = new FileInputStream(path);
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet excel =  workbook.getSheetAt(0);
	
//	enterData(excel.getRow(userRow).getCell(userCell).getStringCellValue(),
//			      excel.getRow(passRow).getCell(passCell).getStringCellValue());
	
	DataFormatter formatter = new DataFormatter();

	String username = formatter.formatCellValue(excel.getRow(arr[0]).getCell(arr[1]));
	String number = formatter.formatCellValue(excel.getRow(arr[2]).getCell(arr[3]));

	enterData(username, number);

	
	workbook.close();
	
	
	}

}
