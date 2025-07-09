package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="C:\\Users\\manvsriv\\Practo\\PractoAutomation\\src\\test\\resource\\Features\\Practo.feature", 
glue="com.stepDefinition",

plugin = {
	    "json:target/jsonreport.json",
	    "junit:target/junitReport.xml",
	    "html:target/cucumberReport/HtmlReport.html",
	    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
	}
)

public class RunnerCodewithTestNG extends AbstractTestNGCucumberTests{

}
