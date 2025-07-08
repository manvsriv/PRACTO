package com.setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Setup {
	
	public static WebDriver driver;
	public static ChromeOptions coptions;
	public static EdgeOptions eoptions;
	
	public static WebDriver chromeDriver()
	{
		WebDriverManager.chromedriver().setup();
		
		coptions = new ChromeOptions();
		coptions.addArguments("--start-maximized");  
		coptions.addArguments("Incognito");
		coptions.addArguments("disable-notifications");
		coptions.addArguments("disable-popup-blocking");
		
		
		driver = new ChromeDriver(coptions);
		
		  File file = new File("C:\\Users\\manvsriv\\Practo\\PractoAutomation\\src\\test\\resource\\Properties\\url.properties");
		  FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		  Properties properties = new Properties();
		  try {
			properties.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
		driver.get(properties.getProperty("url"));
		return driver;
	}
	
	
	public static WebDriver edgeDriver()
	{
		WebDriverManager.chromedriver().setup();
		
		eoptions = new EdgeOptions();
		eoptions.addArguments("--start-maximized");  
		eoptions.addArguments("Incognito");
		eoptions.addArguments("disable-notifications");
		eoptions.addArguments("disable-popup-blocking");
		
		driver = new EdgeDriver(eoptions);
		  File file = new File("C:\\Users\\manvsriv\\Practo\\PractoAutomation\\src\\test\\resource\\Properties\\url.properties");
		  FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		  Properties properties = new Properties();
		  try {
			properties.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
		driver.get(properties.getProperty("url"));
		return driver;
	}
	
	public void tearDown()
	{
		driver.close();
		
	}

}
