package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArticlesPage extends BasePage {
	WebDriver driver;
	
	@FindBy(xpath="//span[text()='Healthy Eating']")
	WebElement healthyeating;
	
	
	public ArticlesPage(WebDriver driver)
	{
		super(driver);
	}
	
	public void clickHealthyEating()
	{
		healthyeating.click();
	}
	
	

}
