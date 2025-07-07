package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestPage extends BasePage{
	
	@FindBy(xpath="//div[text()='Book Now']")
	WebElement bookNow;
	public TestPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public void clickBookNow() {
		waitUntilWebElementIsVisible(bookNow);
		bookNow.click();;
	}
}
