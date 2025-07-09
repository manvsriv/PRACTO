package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Mobile Number / Email ID']") 
	WebElement username;
	@FindBy(id="password")
	WebElement password;
	@FindBy(id="login")
	WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public void enterUsernamePassword(String phoneNumber,String user_password) {
		waitUntilWebElementIsVisible(username);
		username.sendKeys(phoneNumber);
		waitUntilWebElementIsVisible(password);
		password.sendKeys(user_password);
	}
	
	public void clickLogin() {
		waitUntilWebElementIsVisible(loginButton);
		loginButton.click();;
	}
}
