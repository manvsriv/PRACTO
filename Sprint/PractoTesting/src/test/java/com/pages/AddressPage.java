package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressPage extends BasePage{
	
	@FindBy(xpath="//button[text()='Continue']")
	WebElement continueButton;

	public AddressPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public void selectAddress() {
		
		int x=500;
		int y=450;
		
		try {
			clickUsingRobot(x,y);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void clickContinue() {
		waitUntilWebElementIsVisible(continueButton);
		waitUntilWebElementIsClickable(continueButton);
		continueButton.click();
	}
}
