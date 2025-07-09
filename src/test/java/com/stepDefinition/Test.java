package com.stepDefinition;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.pages.ArticlesPage;
import com.pages.CaseStudiesPage;
import com.pages.ConsultPage;
import com.pages.GithubPage;
import com.pages.HealthyEatingPage;
import com.pages.HelpPage;
import com.pages.HomePage;
import com.pages.ModulePage;
import com.pages.PatientDetailsPage;
import com.pages.PediatricianPage;
import com.pages.SurgeriesPage;
import com.pages.VideoConsultConfirmPage;
import com.parameters.ExcelReader;
import com.setup.Setup;
import com.utility.ScreenshotTest;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Test {
	String original;
	
	WebDriver driver;
	HomePage home;
	ModulePage mod;
	HelpPage help;
	CaseStudiesPage csp;
	GithubPage git;
	ArticlesPage articlespage;
	HealthyEatingPage healthyeatingpage;
	SurgeriesPage surgery;
	ExcelReader excelreader;
	ConsultPage consultpage;
	VideoConsultConfirmPage vccp;
	PediatricianPage pediatricianpage;
	PatientDetailsPage patientdetails;
	ScreenshotTest screenshot;
	
	
	//--------------------Background-------------------------------
	@Given("User is on Practo HomePage.")
	public void user_is_on_practo_home_page() {
		driver=Setup.initializeDriver();
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
	    Assert.assertTrue(csp.isVisible());

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
	   
		 original = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(original)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		
		
		git = new GithubPage(driver);
	    git.title();
	    Assert.assertTrue(git.validate());
	}
	
	//-------------------------Scenario 3--------------------------------------------------------------
	/* created by:
	 * Reviewed By:
	 * Motive:
	 *
	 * *
	 */
	@When("user clicks on the module button")
	public void user_clicks_on_the_module_button() {
	    home.clickfinddocbutton();
	}
	@When("clicks on Read Articles button")
	public void clicks_on_read_articles_button() {
	    mod = new ModulePage(driver);
	    mod.scroll();
	    mod.clickReadArticles();
	}
	@When("clicks on Healthy Eating option")
	public void clicks_on_healthy_eating_option() {
		
		 original = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(original)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		articlespage = new ArticlesPage(driver);
		articlespage.clickHealthyEating();
	     
	}
	@Then("Articles on Healthy Eating appear on a page")
	public void articles_on_healthy_eating_appear_on_a_page() {
		healthyeatingpage = new HealthyEatingPage(driver);
		Assert.assertTrue(healthyeatingpage.isVisible());
	}
	@Then("user navigates back to the module page")
	public void user_navigates_back_to_the_module_page() {
		driver.switchTo().window(original);
	}
	
	
	//-------------------------Scenario 4--------------------------------------------------------------
	/* created by:
	 * Reviewed By:
	 * Motive:
	 *
	 * *
	 */
	
	
	@When("user clicks on the module page")
	public void user_clicks_on_the_module_page() {
	    home.clickfinddocbutton();
	}
	@When("clicks on the Surgeries popup")
	public void clicks_on_the_surgeries_popup() {
	    mod = new ModulePage(driver);
	    mod.clicksurgerybutton();
	}
	@When("scrolls down and clicks Cataract option")
	public void scrolls_down_and_clicks_cataract_option() throws InterruptedException {
		 original = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(original)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		
		surgery = new SurgeriesPage(driver);
		surgery.scroll();
		surgery.surgeryType();
	}
	@When("enters the {string} and {string}")
	public void enters_the_and(String string, String string2) throws IOException, InterruptedException, AWTException {
		excelreader = new ExcelReader();
		int [] data = surgery.surgeryData(string, string2);

		String cred[] = excelreader.provideData(data);
		
		surgery.enterData(cred[0], cred[1]);
		

		
	}
	@Then("validate the Book Appointment button")
	public void validate_the_book_appointment_button() throws InterruptedException {
	    Assert.assertTrue(surgery.validate());
	}
	
	
	//-------------------------Scenario 5--------------------------------------------------------------
	/* created by:
	 * Reviewed By:
	 * Motive:
	 *
	 * *
	 */
	
	@When("user clicks on FindDoc button")
	public void user_clicks_on_find_doc_button() {
		home.clickfinddocbutton();
	}
	@When("clicks on Consult with a Doctor button")
	public void clicks_on_consult_with_a_doctor_button() {
		   mod = new ModulePage(driver);
		    mod.clickConsultButton();
	}
	@When("clicks on Consult Now button")
	public void clicks_on_consult_now_button() {
		 original = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(original)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		
		consultpage = new ConsultPage(driver);
		consultpage.clickConsultNowBtn();
		}
	@When("enters the VALID symptom and phonenumber using Data Table")
	public void enters_the_valid_symptom_and_phonenumber_using_data_table(DataTable dataTable) throws IOException {

		vccp = new VideoConsultConfirmPage(driver);
		excelreader = new ExcelReader();
		List<String> list = dataTable.asList(String.class);
		String cred[] = excelreader.loginReader(list.get(0));
		vccp.enterData1(cred[0], cred[1]);
		
	}
	@Then("OTP popup appears")
	public void otp_popup_appears() {
	    Assert.assertTrue(vccp.validate());
	}

	
	//-------------------------Scenario 6--------------------------------------------------------------
	/* created by:
	 * Reviewed By:
	 * Motive:
	 *
	 * *
	 */
	@When("user clicks on FindDoc button on HomePage")
	public void user_clicks_on_find_doc_button_on_home_page() {
		home.clickfinddocbutton();
	}
	@When("clicks on consult with a Doctor button on the module page")
	public void clicks_on_consult_with_a_doctor_button_on_the_module_page() {
		 mod = new ModulePage(driver);
		    mod.clickConsultButton();
	}
	@When("clicks on Consult Now button on the page")
	public void clicks_on_consult_now_button_on_the_page() {
		 original = driver.getWindowHandle();
			Set<String> allWindows = driver.getWindowHandles();
			for (String windowHandle : allWindows) {
				if (!windowHandle.equals(original)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}
			
			consultpage = new ConsultPage(driver);
			consultpage.clickConsultNowBtn();
	}
	@When("enters the INVALID symptom and phonenumber using Property file")
	public void enters_the_invalid_symptom_and_phonenumber_using_property_file() {
	      vccp = new VideoConsultConfirmPage(driver);
	      vccp.enterData();
	}
	@Then("OTP PopUp appears")
	public void otp_pop_up_appears() {
		Assert.assertTrue(vccp.validate());
	}
	
	//-------------------------Scenario 7--------------------------------------------------------------
	/* created by:
	 * Reviewed By:
	 * Motive:
	 *
	 * *
	 */

	@When("user clicks on module page icon on home page")
	public void user_clicks_on_module_page_icon_on_home_page() {
	    home.clickfinddocbutton();
	}
	@When("clicks on Pediatrician option on Module Page")
	public void clicks_on_pediatrician_option_on_module_page() {
		mod = new ModulePage(driver);
	    mod.clickPediatrician();
	}
	@When("applies filters")
	public void applies_filters() {
	    pediatricianpage = new PediatricianPage(driver);
	    pediatricianpage.selectExperience();
	}
	@When("clicks on Book Clinic Visit")
	public void clicks_on_book_clinic_visit() {
	    pediatricianpage.bookClinicVisit();
	}
	@When("enters OTP")
	public void enters_otp() {
	    pediatricianpage.enterOTP();
	}

	
	@When("enters both Valid and Invalid Credentials from {int} and {int}")
	public void enters_both_valid_and_invalid_credentials_from_and(Integer sheetno, Integer rowno) throws IOException {
		patientdetails = new PatientDetailsPage(driver);
		 excelreader = new ExcelReader();
		 String[] data = excelreader.getCred(sheetno, rowno);
		 patientdetails.enterdetails(data[0], data[1]);
	}
	
	@Then("Booking Confirmation page should appear")
	public void booking_confirmation_page_should_appear() {
		Assert.assertTrue(patientdetails.validate());
	}
	
	@After
	public void tearDown(Scenario scenario) // wil take screenshots for each and every scenario
	{
		final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "Image");
		
	}
}
