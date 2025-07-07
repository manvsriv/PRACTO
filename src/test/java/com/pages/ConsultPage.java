package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.WebDriver;

public class ConsultPage extends BasePage{
	
	public ConsultPage(WebDriver driver)
	{
		super(driver);
	}
	
	public void clickConsultNowBtn()
	{
		Robot robot = null ;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		robot.mouseMove(150,570);
		robot.delay(1000);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}

}
