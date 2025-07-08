package com.runner;


import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="C:\\Users\\manvsriv\\Practo\\PractoAutomation\\src\\test\\resource\\Features\\Practo.feature",
glue ="com.stepDefinition")
public class RunnerParallelTesting  extends AbstractTestNGCucumberTests{

	@Override
	@DataProvider(parallel=true)  // this will run the scenarios 
	public Object[][] scenarios() {
		
		return super.scenarios();
	}
	
	

}
