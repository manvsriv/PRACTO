package com.stepDefination;
 
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import com.pages.ConsultNowPage;
import com.pages.ConsultationFormPage;
import com.pages.Homepage;
import com.pages.VideoConsultPage;
import com.parameters.ExcelReader;
import com.setup.BaseSteps;
import com.utility.TestDataReader;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
 

public class VideoConsultSteps {
    WebDriver driver;
    Homepage homePage;
    ConsultNowPage consultNowPage;
    ConsultationFormPage consultationFormPage;
    VideoConsultPage videoConsultpage;
    ExcelReader reader;
    
    
    
    @Given("User is on the Practo homepage")
    public void user_is_on_the_practo_homepage() {
        driver = BaseSteps.chromedriver();
        driver.get("https://www.practo.com");
        homePage = new Homepage(driver);
    }

    @When("User clicks on the Video Consult link")
    public void user_clicks_on_the_video_consult_link() {
        homePage = new Homepage(driver);
        homePage.clickVideoConsultLink();
    }

    
    
  //-------------------------Scenario 1--------------------------------------------------------------
  	/* created by: Lavanya Kadadas
  	 * Reviewed By:
  	 * Motive: Verify Consult Now button is clickable and open Consultation form
  	 *
  	 * *
  	 */
    
    @When("User clicks on Video Consult link from homepage")
    public void user_clicks_on_video_consult_link_from_homepage() {
        driver = BaseSteps.chromedriver();
        homePage = new Homepage(driver);
        homePage.clickVideoConsultLink();
    }

    @When("User Clicks on Consult Now button on Video Consult Page")
    public void user_clicks_on_consult_now_button_on_video_consult_page() {
        consultNowPage = new ConsultNowPage(driver);
        consultNowPage.clickConsultNowButton();
    }

    @Then("Consultation form should be displayed successfully")
    public void consultation_form_should_be_displayed_successfully() {
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.practo.com/consult/direct/new_consultation"));
    }

    
    
    
    //-------------------------Scenario 2--------------------------------------------------------------
    	/* created by: Lavanya Kadadas
    	 * Reviewed By:
    	 * Motive: Verify new mobile number 
    	 *
    	 * *
    	 */
    
    @When("User enters symptom {string} in the symptom input field")
    public void user_enters_symptom_in_the_symptom_input_field(String string) {
        consultationFormPage = new ConsultationFormPage(driver);
        reader = new ExcelReader();
        String data = reader.provideLoginData(string);
        consultationFormPage.enterSymptom(data);
    }
    @When("User selects speciality Pediatrics from the list")
    public void user_selects_speciality_pediatrics_from_the_list() {
        
    	 consultationFormPage.selectSpeciality();
    }

    @When("User scrolls to mobile number input")
    public void user_scrolls_to_mobile_number_input() {
        consultationFormPage.scrollToMobileInput();
    }

    @When("User enters new mobile number {string}")
    public void user_enters_new_mobile_number(String string) {
        consultationFormPage = new ConsultationFormPage(driver);
        reader = new ExcelReader();
        String data = reader.provideLoginData(string);
        consultationFormPage.enterMobileNumber(data);
    }

    @Then("Continue button is active")
    public void continue_button_is_active() {
    	consultationFormPage = new ConsultationFormPage(driver);
    	Assert.assertTrue(consultationFormPage.EnableContinue());
         
    }

     
 
 
    
    //-------------------------Scenario 3--------------------------------------------------------------
    	/* created by: Lavanya Kadadas
    	 * Reviewed By:
    	 * Motive: Verify Continue button is inactive when symptom is less than 4 characters
    	 *
    	 * *
    	 */
 


@When("User enters invalid symptom from properties")
public void user_enters_invalid_symptom_from_properties()
{
	consultationFormPage = new ConsultationFormPage(driver);
	String symptom = TestDataReader.get("invalid.symptom1");
	consultationFormPage.enterSymptom(symptom);
}

@Then("Continue button should be inactive")
public void continue_button_should_be_inactive() 
{
	consultationFormPage=new ConsultationFormPage(driver);
	Assert.assertEquals(consultationFormPage.EnableContinue(),true);
}


//-------------------------Scenario 4--------------------------------------------------------------
	/* created by: Lavanya Kadadas
	 * Reviewed By:
	 * Motive:  Validate the visibility of Practo LinkedIn page
	 *
	 * *
	 */



@When("User scrolls to the bottom of the page")
public void user_scrolls_to_bottom_of_the_page() {
    try {
        Robot robot = new Robot();
        for (int i = 0; i < 10; i++) {
            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
            robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
            Thread.sleep(300);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

@When("User clicks on the LinkedIn button")
public void user_clicks_on_the_linkedin_button() {
    videoConsultpage = new VideoConsultPage(driver);
    videoConsultpage.clickLinkedInButton();
}

@Then("Practo LinkedIn page should open in a new tab")
public void practo_linkedin_page_should_open_in_a_new_tab() {
    ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1));
    String currentUrl = driver.getCurrentUrl();
    Assert.assertTrue(currentUrl.contains("linkedin.com/company/practo"));
}

//-------------------------Scenario 5--------------------------------------------------------------
	/* created by: Lavanya Kadadas
	 * Reviewed By:
	 * Motive: Verify redirection to homepage on Practo logo click
	 *
	 * *
	 */
 

@When("User clicks on the Practo logo")
public void user_clicks_on_the_practo_logo() {
    consultationFormPage = new ConsultationFormPage(driver);
    consultationFormPage.scrollToTopUsingRobot();
    consultationFormPage.clickPractoLogoUsingActions();
}

@Then("User should be redirected to the Practo homepage")
public void user_should_be_redirected_to_the_practo_homepage() {
    String currentUrl = driver.getCurrentUrl();
    Assert.assertEquals("https://www.practo.com/", currentUrl);
}

//-------------------------Scenario 6--------------------------------------------------------------
	/* created by: Lavanya Kadadas
	 * Reviewed By:
	 * Motive:  Validate booking Video Consultation with valid credentials using DataTable
	 *
	 * *
	 */

@When("enters the VALID symptom and phonenumber using Data Table")
public void enters_the_valid_symptom_and_phonenumber_using_data_table(io.cucumber.datatable.DataTable dataTable) {
    List<List<String>> data = dataTable.asLists();
    String excelFilePath = "src/test/resource/Exceldata/" + data.get(0).get(0); // e.g., "Credentials.xlsx"

    List<List<String>> credentials = ExcelReader.readExcelData(excelFilePath);
    for (List<String> row : credentials) {
        String symptom = row.get(0);
        String phoneNumber = row.get(1);

        consultationFormPage = new ConsultationFormPage(driver);
        consultationFormPage.enterSymptom(symptom);
        consultationFormPage.enterMobileNumber(phoneNumber);
    }
}

//-------------------------Screenshot Method--------------------------------------------------------------
	 
 

@After
public void tearDown(Scenario scenario) // will take screenshots for each and every scenario
{
	final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	 scenario.attach(screenshot, "image/png", "Image");
}


}



 
    
     




