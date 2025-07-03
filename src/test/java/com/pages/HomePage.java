package com.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	WebDriver driver;

	@FindBy(xpath="//a[@aria-label='Find Doctors Near You']") WebElement findbutton;

	public String original;
	public Set<String> allWindows;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void clickfinddocbutton() {

		original = driver.getWindowHandle();
		waitUntilWebElementIsVisible(findbutton);
		findbutton.click();

		allWindows = driver.getWindowHandles();
	}

}
