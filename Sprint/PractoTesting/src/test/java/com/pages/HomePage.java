package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
	WebDriver driver;
	
	@FindBy(xpath="//a[text()='Login / Signup']") 
	WebElement login;
	
	@FindBy(xpath="//div[text()='Surgeries']") 
	WebElement surgeries;
	
	@FindBy(linkText="Lab Tests")
	WebElement labtest;
	
	public HomePage(WebDriver driver) {
		super(driver);
		//System.out.println("HomePage"+driver);
		this.driver=driver;
	}
	
	public void clickLoginButton(){
		
		waitUntilWebElementIsVisible(login);
		waitUntilWebElementIsClickable(login);
		login.click();
		
	}
	
	public void clickLabTests() {
		waitUntilWebElementIsVisible(labtest);
		waitUntilWebElementIsClickable(labtest);
		labtest.click();
	}
}
