package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;

public class PatientDetailsPage extends BasePage{
	
	@FindBy(xpath="//label[text()='Someone Else']")
	WebElement radiobutton;
	
	@FindBy(xpath="//div[text()='We will send you an SMS and email with the appointment and practice details']")
	WebElement validationmsg;
	
	
	public PatientDetailsPage(WebDriver driver)
	{
		super(driver);
	}
	
	public void enterdetails(String name, String number)
	{
		waitUntilWebElementIsClickable(radiobutton);
		radiobutton.click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).sendKeys(name).build().perform();
		action.sendKeys(Keys.TAB).sendKeys(number).build().perform();
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
	}
	
	public boolean validate()
	{
		waitUntilWebElementIsVisible(validationmsg);
		   boolean validate = driver.findElement(By.xpath("//div[text()='We will send you an SMS and email with the appointment and practice details']")).isDisplayed();
		   System.out.println(validate);
		   return validate;
		   
	}

}
