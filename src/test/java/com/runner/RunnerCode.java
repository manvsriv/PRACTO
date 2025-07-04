package com.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)  //  this annotation is only for JUnit not for testNG
@CucumberOptions(features="C:\\Users\\manvsriv\\Practo\\PractoAutomation\\src\\test\\resource\\Features\\Practo.feature", 
glue="com.stepDefinition")
public class RunnerCode {

}
