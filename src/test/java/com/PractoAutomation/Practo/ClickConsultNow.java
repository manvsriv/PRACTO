package com.PractoAutomation.Practo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClickConsultNow 
{
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.practo.com/");
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
 
		WebElement videoConsult=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Video Consult']")));
		videoConsult.click();
		WebElement consultNow=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Consult Now']")));
//		driver.findElement(By.xpath("//a[text()='Consult Now']")).click();
		consultNow.click();
	
		
		System.out.println("Consult Now button clicked Successfully");
		driver.quit();
	}

}
