package com.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {

	WebDriver driver;
	WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
//	public void launchbrowser(WebDriver driver)
//	{
//		driver.get("https://www.saucedemo.com/");
//	}

	public void waitUntilWebElementIsVisible(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void waitUntilWebElementIsClickable(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public boolean isElementClickable(WebElement element) {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	        return true;
	    } catch (TimeoutException e) {
	        return false;
	    }
	}

	


}

