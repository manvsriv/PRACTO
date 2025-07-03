package com.pages;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModulePage extends BasePage{
	
	WebDriver driver;

    
	@FindBy(xpath="//span[text()='Security & help']")
	WebElement drop;
	
	public ModulePage(WebDriver driver)
	{
		super(driver);
	}
	
	public void clickbutton() throws InterruptedException
	{
		waitUntilWebElementIsVisible(drop);
		drop.click();
    }

}
