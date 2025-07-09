package com.runner;

import org.testng.annotations.DataProvider;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="C:\\Users\\SDHINDLE\\Desktop\\PRACTO\\Sprint\\PractoTesting\\src\\test\\resource\\Features\\LabTests.feature",
glue=("com.stepDefinition"))
public class TestRunnerParallelTest extends AbstractTestNGCucumberTests{
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios() {
		// TODO Auto-generated method stub
		return super.scenarios();
	}
}
