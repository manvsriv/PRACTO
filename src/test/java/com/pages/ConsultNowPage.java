package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ConsultNowPage extends BasePage
{
	 public ConsultNowPage(WebDriver driver)
	 {
		 super(driver);
		 this.driver=driver;
	 }
	 
	 
	 public void clickConsultNowButton()
	 {
		 try
		 {
			 WebElement consultNowButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Consult Now']")));
			 Actions actions=new Actions(driver);
			 actions.moveToElement(consultNowButton).click().build().perform();
			 
		 }catch(Exception e)
		 {
			 System.out.println("Error Clicking Consult Now"+e.getMessage());
		 }
	 }
	 
//	 public boolean isConsultationFormVisible()
//	 {
//		 try
//		 {
//			 WebElement header=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text().'Consultation')]")));
//			 return header.isDisplayed();
//		 }catch(Exception e)
//		 {
//			 return false;
//		 }
//	 }
	
}
