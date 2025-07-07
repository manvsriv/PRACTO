package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VideoConsultPage extends BasePage
{
	//WebDriverWait wait;
	Actions actions;
	public VideoConsultPage(WebDriver driver)
	{
		super(driver);
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		actions=new Actions(driver);
	}
	
	public void clickConsultNowButton(String buttonText)
	{
		try
		{
		WebElement button=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Consult Now']")));
		
		actions.moveToElement(button).click().build().perform();
		}catch(Exception e)
		{
		
		System.out.println("Error clicking consult now button"+e.getMessage());
	}
	}

}
