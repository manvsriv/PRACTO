package com.runner;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features="src\\test\\resource\\Features\\HomePage.feature",
glue ="com.stepDefinition")
 
public class TestRunnerParallelTest  extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel=true)  // this will run the scenarios
	public Object[][] scenarios() {
		
		return super.scenarios();
	}
}
