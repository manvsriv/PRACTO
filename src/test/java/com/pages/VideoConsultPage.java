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
	 
	Actions actions;
	public VideoConsultPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
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
	 
    private By linkedInButton = By.xpath("//a[contains(@href,'linkedin.com')]");

    public void clickLinkedInButton() 
    {
    	try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			 
			e.printStackTrace();
		}
        WebElement button = driver.findElement(linkedInButton);
        try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			 
			e.printStackTrace();
		}
        actions.moveToElement(button).click().perform();
    }
 

}
