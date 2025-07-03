package com.stepDefinition;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.pages.HomePage;
import com.pages.ModulePage;
import com.setup.Setup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test {
	
	WebDriver driver;
	HomePage home;
	ModulePage mod;
	
	
	@Given("user is on Module Page")
	public void user_is_on_module_page() {

		driver = Setup.chromeDriver();
		home = new HomePage(driver);
		home.clickfinddocbutton();
	}
	@When("clicks on the Medical Records button")
	public void clicks_on_the_medical_records_button() throws InterruptedException{
		
		for (String windowHandle : home.allWindows) {
			if (!windowHandle.equals(home.original)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
	    mod = new ModulePage(driver);
	    mod.clickbutton();
	}
	@Then("page opens")
	public void page_opens() {
	    
	}

}
