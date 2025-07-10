package com.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)  
@CucumberOptions(features="C:\\Users\\manvsriv\\Practo\\PractoAutomation\\src\\test\\resource\\Features\\Practo.feature", 
glue="com.stepDefinition",
dryRun =false,
tags="@Negative",
//monochrome = true,
plugin= {
		"json:C:\\Users\\manvsriv\\Practo\\PractoAutomation\\target/jsonreport.json",
		"junit:C:\\Users\\manvsriv\\Practo\\PractoAutomation\\target/junitReport.xml",
		"html:C:\\Users\\manvsriv\\Practo\\PractoAutomation\\target/cucumberReport/HtmlReport.html"})
public class RunnerCode {

}

