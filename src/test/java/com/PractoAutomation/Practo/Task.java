package com.PractoAutomation.Practo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task 
{
	    public static void main(String[] args) {
	        WebDriver driver = new ChromeDriver();
	        driver.get("https://money.rediff.com/gainers");

 
	        WebElement prevClose = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td[3]"));
	        WebElement currentPrice = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td[4]"));
	        WebElement companyName = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td[1]"));

	        System.out.println("Company: " + companyName.getText());
	        System.out.println("Company: " + prevClose.getText());
	        System.out.println("Company: " + currentPrice.getText());
	        
	        driver.quit();
	    }
	}

	

