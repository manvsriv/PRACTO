package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	WebDriver driver;

	@FindBy(xpath="//a[@aria-label='Find Doctors Near You']") 
	WebElement findbutton;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void clickfinddocbutton() 
	{
        waitUntilWebElementIsClickable(findbutton);
		findbutton.click();
	}
	


}
