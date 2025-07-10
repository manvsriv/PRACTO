package com.runner;

 
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src\\test\\resource\\Features\\PractoVideoConsult.feature",
		glue="stepDefination",
		plugin= {"pretty:target/pretty.txt",
				"html:target/cucumberreport/htmlreport.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				})
		 
public class TestRunnerTestNG  extends AbstractTestNGCucumberTests{

}
