package com.PractoAutomation.Practo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenHomepage 
{
	 public static void main(String[] args) {
		
		 WebDriver driver=new ChromeDriver();
		 driver.get("https://www.practo.com/");
		 String title=driver.getTitle();
		 if(title.contains("Practo"))
		 {
			 System.out.println("Practo Homepage");
			 
		 }
		 else
		 {
			 System.out.println("Failed");
		 }
		 driver.quit();
	}

}
