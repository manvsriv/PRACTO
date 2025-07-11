package com.PractoAutomation.PractoTesting;



import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



import io.github.bonigarcia.wdm.WebDriverManager;


public class AppLink {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();	 
		driver.get("https://www.practo.com/care");		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("Lab Tests")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='/tests/public/icons/topcities/Pune.svg?1556796588']")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		   // js.executeScript("location.reload()");
		    js.executeScript("window.scrollBy(0,3300)");

			Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@placeholder='Enter phone number']")).sendKeys("5457669879865546");
		 
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//div[text()='Send app link']")).click();
		 
		 Thread.sleep(2000);
		 WebElement errorMessage=driver.findElement(By.xpath("//div[text()='Enter valid mobile number']"));
		 System.out.println(errorMessage.getText());

        boolean isErrorMessageDisplayed = errorMessage.getText().equals("Enter valid mobile number");
		//Assert.assertTrue(isErrorMessageDisplayed,"Not Displayed");
        Assert.assertTrue("Not Displayed", isErrorMessageDisplayed);
	}

}
