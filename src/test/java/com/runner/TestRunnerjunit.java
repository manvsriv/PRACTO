package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src\\test\\resource\\Features\\PractoVideoConsult.feature",
		glue="stepDefination",
		plugin= {"pretty:target/pretty.txt",
				"html:target/cucumberreport/htmlreport.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				})
		 
		

public class TestRunnerjunit 
{
	

}
