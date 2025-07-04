package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;

public class HelpPage extends BasePage{
	
	WebDriver driver;
	
	@FindBy(xpath="//a[@title='View all posts in Practo Case Studies']")
	WebElement caseStudiesTitle;
	
	public HelpPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	public void isVisible()
	{
		Assert.assertTrue(caseStudiesTitle.isDisplayed());
		
	}
	
	public void clickOnCaseStudies()
	{
		waitUntilWebElementIsClickable(caseStudiesTitle);
		caseStudiesTitle.click();
	}
	
	

}
