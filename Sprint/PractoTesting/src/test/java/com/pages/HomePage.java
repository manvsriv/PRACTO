package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage{
	WebDriver driver;
	
	@FindBy(xpath="//a[text()='Login / Signup']") 
	WebElement login;
	
	@FindBy(xpath="//div[text()='Surgeries']") 
	WebElement surgeries;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public void clickLoginButton(){
		
		waitUntilWebElementIsVisible(login);
		waitUntilWebElementIsClickable(login);
		login.click();
		
	}
}
