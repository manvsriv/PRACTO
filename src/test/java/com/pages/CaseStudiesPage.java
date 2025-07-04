package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;

public class CaseStudiesPage extends BasePage{
	WebDriver driver;
	
	@FindBy(xpath="//a[text()='Prime Case Studies']")
	WebElement primeCaseStudies;
	
	@FindBy(xpath="//a[text()='Ray Case Studies']")
	WebElement raycasestudies;
	
	public CaseStudiesPage(WebDriver driver)
	{
		super(driver);
	}
	
	public void isVisible()
	{
		Assert.assertTrue(primeCaseStudies.isDisplayed());
		
		String name1 = primeCaseStudies.getText();
		System.out.println(name1);
		
		String name2= raycasestudies.getText();
		System.out.println(name2);
	}
	

}
