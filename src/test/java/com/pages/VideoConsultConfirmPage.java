package com.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VideoConsultConfirmPage extends BasePage {

	@FindBy(xpath = "//textarea[@placeholder='Eg: fever, headache']")
	WebElement symptom;

	@FindBy(xpath = "//input[@placeholder='Enter mobile number']")
	WebElement phonenumber;

	@FindBy(xpath = "//label[text()='Choose a relevant speciality']")
	WebElement validate;

	public VideoConsultConfirmPage(WebDriver driver) {
		super(driver);
	}

	public void enterData()  //for invalid values in Scenario 6
	{
		File file = new File(
				"C:\\Users\\manvsriv\\Practo\\PractoAutomation\\src\\test\\resource\\Properties\\InvalidCredentials.properties");
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

		symptom.sendKeys(properties.getProperty("invalidSymptom"));
		phonenumber.sendKeys(properties.getProperty("invalidPhNumber"));
		
	}
	
	public void enterData1(String symp, String phnum) // for valid values in Scenario 5
	{
		symptom.sendKeys(symp);
		phonenumber.sendKeys(phnum);
	}

	public boolean validate() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean result = validate.isDisplayed();
		return result;
	}

}
