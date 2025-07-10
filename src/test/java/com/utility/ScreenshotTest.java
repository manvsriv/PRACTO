package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotTest {

	public static void captureScreen(WebDriver driver , String filename) throws IOException
	{
		//1st way
		TakesScreenshot screen=(TakesScreenshot) driver;
		File src= screen.getScreenshotAs (OutputType.FILE);
		File dest= new File("./Screenshots/"+filename+".png");
		FileUtils.copyFile(src, dest);

		// 2nd way
//		TakesScreenshot screen1=(TakesScreenshot) driver;
//		File srcl= screen1.getScreenshotAs (OutputType.FILE);
//		FileUtils.copyFile(srcl, new File("./Screenshots/"+filename+".png"));
	}
	
	public static void takeScreen (WebDriver driver) 

	{

	File src2= ((TakesScreenshot) driver) .getScreenshotAs (OutputType. FILE) ;
	try {
		FileUtils.copyFile(src2, new File("./Screenshots/"+timestamp() +" "+".png") ) ;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

	public static String timestamp () {
	return new SimpleDateFormat("yyyy-mm-dd HH-mm-ss") .format (new Date () ) ;
     }
	
	
	
	//below for ExtentReport
	public static String takesScreen(WebDriver driver, String filename) throws IOException
	{
		TakesScreenshot screen1=(TakesScreenshot)driver;  //TakeScreenshot is an interface
		File src1= screen1.getScreenshotAs(OutputType.FILE);
		String screens="C:\\Users\\manvsriv\\Practo\\PractoAutomation\\ExtentReportScreenshot"
		+filename+".png";
		File dest=new File(screens);
	   FileUtils.copyFile(src1, dest);
		return screens;
		
		
	}
}
