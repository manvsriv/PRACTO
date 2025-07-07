package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage extends BasePage
{
 

    public Homepage(WebDriver driver) {
 
    	super(driver);
    	this.driver=driver;
    }
    
    public void clickVideoConsultLink()
    {
    	try
    	{
    		WebElement videConsultLink=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Video Consult")));
    		Actions actions=new Actions(driver);
    		actions.moveToElement(videConsultLink).click().build().perform();
    	}catch(Exception e)
    	{
    		System.out.println("Error clicking video consult"+e.getMessage());
    	}
    }

 


}
