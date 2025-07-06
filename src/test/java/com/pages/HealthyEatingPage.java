package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;

public class HealthyEatingPage extends BasePage {
	WebDriver driver;
	
	@FindBy(linkText="3 Health Myths to Leave Behind in The New Year")
	WebElement heading;
	
	public HealthyEatingPage(WebDriver driver)
	{
		super(driver);
	}
	
	public void isVisible()
	{
		Assert.assertTrue(heading.isDisplayed());
	}
	

}
