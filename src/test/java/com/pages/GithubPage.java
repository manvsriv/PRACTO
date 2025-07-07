package com.pages;

import org.openqa.selenium.WebDriver;

import junit.framework.Assert;

public class GithubPage extends BasePage{
	
	//WebDriver driver;
	
	public GithubPage(WebDriver driver)
	{
		super(driver);
	}
	
	public void title()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String title= driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Practo · GitHub", title);
	}

}
