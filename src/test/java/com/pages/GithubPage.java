package com.pages;

import org.openqa.selenium.WebDriver;

import junit.framework.Assert;

public class GithubPage extends BasePage{
	
	String title;
	
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
		 title= driver.getTitle();
		System.out.println(title);
		//Assert.assertEquals("Practo · GitHub", title);
	}
	
	public boolean validate()
	{
		boolean condition= title.matches("Practo · GitHub");
		return condition;
	}

}
