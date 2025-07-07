package com.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

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
	
	@FindBy(xpath="//span[text()='Read articles']")
	WebElement readarticles;
	
	@FindBy(xpath="//span[text()='Book appointment with an expert surgeon ']")
	WebElement surgerybutton;
	
	@FindBy(xpath="//span[text()='Consult with a doctor']")
	WebElement consultdocbutton;
	
	public ModulePage(WebDriver driver)
	{
		super(driver);
		
	}
	
	public void securityAndHelpDropdown()
	{
		waitUntilWebElementIsVisible(heading);
		SecurityandHelpbutton.click();
	}
	
	public void helpButton()
	{
		waitUntilWebElementIsClickable(Helpbutton);
		
		Helpbutton.click();
		
	}
	
	public void scrollTobottom()
	{
	    waitUntilWebElementIsVisible(heading);
		//System.out.println("Driver is: " + driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}
	
	public void scroll()
	{
		 waitUntilWebElementIsVisible(heading);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,500)"); 
		 
	}
	
	public void clickReadArticles()
	{
		readarticles.click();
	}
	
	
	public void clickGithub()
	{
		git.click();
	}
	
	public void clicksurgerybutton()
	{
		waitUntilWebElementIsClickable(surgerybutton);
		surgerybutton.click();
	}
	
	
	public void clickConsultButton()
	{
		waitUntilWebElementIsVisible(heading);
		consultdocbutton.click();
	}


}
