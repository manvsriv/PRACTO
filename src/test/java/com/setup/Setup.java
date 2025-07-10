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
	 public static Properties properties;
	
    static {
        try {
            FileInputStream fis = new FileInputStream(
                "C:\\Users\\manvsriv\\Practo\\PractoAutomation\\src\\test\\resource\\Properties\\url.properties");
             properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static WebDriver initializeDriver() {
        String browser = properties.getProperty("browser").toLowerCase().trim();


        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                coptions = new ChromeOptions();
                coptions.addArguments("--start-maximized", "incognito", "disable-notifications", "disable-popup-blocking");
                driver = new ChromeDriver(coptions);
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                eoptions = new EdgeOptions();
                eoptions.addArguments("--start-maximized", "inprivate", "disable-notifications", "disable-popup-blocking");
                driver = new EdgeDriver(eoptions);
                break;

            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }

        driver.get(properties.getProperty("url"));
        return driver;
    }


	

	
	public void tearDown()
	{
		driver.close();
		
	}

}
