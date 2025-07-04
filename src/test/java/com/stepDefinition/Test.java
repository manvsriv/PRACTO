package com.stepDefinition;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.pages.CaseStudiesPage;
import com.pages.GithubPage;
import com.pages.HelpPage;
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
	HelpPage help;
	CaseStudiesPage csp;
	GithubPage git;
	
	//--------------------Background-------------------------------
	@Given("User is on Practo HomePage.")
	public void user_is_on_practo_home_page() {
		driver=Setup.chromeDriver();
		  home = new HomePage(driver);
	}
	
	//-------------------------Scenario 1--------------------------------------------------------------
	/* created by:
	 * Reviewed By:
	 * Motive:
	 *
	 * *
	 */
	@When("user clicks Find Doctors near you button")
	public void user_clicks_find_doctors_near_you_button() {
		home.clickfinddocbutton();
	}
	@When("clicks on Security and Help dropdown menu")
	public void clicks_on_security_and_help_dropdown_menu() {
		mod = new ModulePage(driver);
		   mod.securityAndHelpDropdown();
	}
	@When("clicks on help")
	public void clicks_on_help() {
		mod.helpButton();
	}
	@Then("Practo help page should appear")
	public void practo_help_page_should_appear() {
		  help = new HelpPage(driver);
		    help.isVisible();
	}
	@Then("clicks on Practo Case Studies")
	public void clicks_on_practo_case_studies() {
		  help.clickOnCaseStudies();
	}
	@Then("Practo Case Studies Page appears.")
	public void practo_case_studies_page_appears() {
		csp = new CaseStudiesPage(driver);
	    csp.isVisible();
	}
	
	//-------------------------Scenario 2--------------------------------------------------------------
		/* created by:
		 * Reviewed By:
		 * Motive:
		 *
		 * *
		 */
	
	@When("user clicks Find Doctors near you button on homepage")
	public void user_clicks_find_doctors_near_you_button_on_homepage() {
		home.clickfinddocbutton();
	}
	@When("clicks Find Doctors near you buttonscrolls to the bottom of the page")
	public void clicks_find_doctors_near_you_buttonscrolls_to_the_bottom_of_the_page() throws InterruptedException {
		mod = new ModulePage(driver);
		mod.scrollTobottom();
		}
	@When("clicks on the Github button")
	public void clicks_on_the_github_button() {
	   mod.clickGithub();
	}
	@Then("Practo Github Page opens.")
	public void practo_github_page_opens() {
	   
		String original = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(original)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		git = new GithubPage(driver);
	    git.title();
	}
	
	
}
