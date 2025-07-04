package com.PractoAutomation.Practo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnterSymptomAndVerifySpeciality 
{
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.practo.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

       
            
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Video Consult']")));
            WebElement videoConsult = driver.findElement(By.xpath("//div[text()='Video Consult']"));
            videoConsult.click();
 
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Consult Now']")));
            WebElement consultNow = driver.findElement(By.xpath("//a[text()='Consult Now']"));
            consultNow.click();
           
 
            wait.until(ExpectedConditions.elementToBeClickable(By.name("detailedDescription")));
           
            WebElement symptomField = driver.findElement(By.name("detailedDescription"));
            symptomField.sendKeys("fever");

             
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='\r\n"
            		+ "                    Pediatrics\r\n"
            		+ "                    "
            		+ "                    ']")));
            WebElement specialityOption = driver.findElement(By.xpath("//label[text()='\r\n"
            		+ "                    Pediatrics\r\n"
            		+ "                    "
            		+ "                    ']"));
            
//            WebElement specialityOption=driver.findElement(By.xpath("//input[@name='problemArea' and @checked]"));
          

//         String selectedValue=specialityOption.getAttribute("value");
//         System.out.println("Default selected speciality value is:"+selectedValue);
//            
           

        driver.quit();

	}

}
