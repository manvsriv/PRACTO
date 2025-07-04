package com.pages;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModulePage extends BasePage{
	
	//WebDriver driver;

    
	@FindBy(xpath="//span[text()='Security & help']")
	WebElement SecurityandHelpbutton;
	
	@FindBy(xpath="//span[text()='Help']")
	WebElement Helpbutton;
	
	@FindBy(xpath="//h1[text()='Your home for health']")
	WebElement heading;
	
	@FindBy(xpath="//span[text()='Github']")
	WebElement git;
	
	public ModulePage(WebDriver driver)
	{
		super(driver);
		System.out.println("in Module page factor : "+driver);
		//PageFactory.initElements(driver, this);
	}
	
	public void securityAndHelpDropdown()
	{
		waitUntilWebElementIsVisible(heading);
		System.out.println("security and help dropdown");
		SecurityandHelpbutton.click();
	}
	
	public void helpButton()
	{
		waitUntilWebElementIsClickable(Helpbutton);
		
		Helpbutton.click();
		
	}
	
	public void scrollTobottom() throws InterruptedException
	{
		//waitUntilWebElementIsVisible(heading);
		Thread.sleep(3000);
		System.out.println("Driver is: " + driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}
	
	public void clickGithub()
	{
		git.click();
	}
	
	

}
