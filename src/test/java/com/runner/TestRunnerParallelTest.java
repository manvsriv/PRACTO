package com.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features="src\\test\\resource\\Features\\PractoVideoConsult.feature",
		glue="stepDefination")
public class TestRunnerParallelTest extends AbstractTestNGCucumberTests 
{
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios() {
		// TODO Auto-generated method stub
		return super.scenarios();

}
}
