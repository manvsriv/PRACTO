package com.pages;

import org.openqa.selenium.WebDriver;

public class GithubPage extends BasePage{
	
	WebDriver driver;
	
	public GithubPage(WebDriver driver)
	{
		super(driver);
	}
	
	public void title()
	{
		String title= driver.getTitle();
		System.out.println(title);
	}

}
