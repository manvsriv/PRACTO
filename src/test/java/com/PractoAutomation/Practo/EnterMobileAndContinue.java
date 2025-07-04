 package com.PractoAutomation.Practo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnterMobileAndContinue {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.practo.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

       
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Video Consult']"))).click();

        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Consult Now']"))).click();

        
        wait.until(ExpectedConditions.elementToBeClickable(By.name("detailedDescription"))).sendKeys("fever");

       
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'Pediatrics')]"))).click();

 



WebElement scrollContainer = driver.findElement(By.cssSelector("div.wrapper-with-nav"));
((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", scrollContainer);

Thread.sleep(2000);
WebElement mobileField = driver.findElement(By.name("mobileInteraction"));
mobileField.sendKeys("7304831857");
Thread.sleep(2000);

//WebElement continueButton=driver.findElement(By.xpath("//button[text()='Continue']"));//this is for the disabled button xpath
//
//continueButton.click();

Thread.sleep(2000);

WebElement continueButton = driver.findElement(By.cssSelector("button.continue-btn:not(.disabled)"));
continueButton.click();
Thread.sleep(2000);


//WebElement continueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Continue']")));
//((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueButton);
//

//WebElement otpInput=driver.findElement(By.xpath("//input[@placeholder='Please enter the 6 digit OTP here to verify"));
//Thread.sleep(2000);
//otpInput.sendKeys("100200");
//Thread.sleep(2000);
//WebElement otp=driver.findElement(By.xpath("//input[@id='mobile_token'"));
//otp.wait();
//otp.click();

WebElement otpInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("mobile_token")));
otpInput.sendKeys("100200");

System.out.println("OTP Entered Successfully");
         driver.quit();
        
    }
}
