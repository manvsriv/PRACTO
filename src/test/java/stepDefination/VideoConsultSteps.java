package stepDefination;
 
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
 

public class VideoConsultSteps {
    WebDriver driver;
    Homepage homePage;
    ConsultNowPage consultNowPage;
    ConsultationFormPage consultationFormPage;
    VideoConsultPage videoConsultpage;
    ExcelReader reader;
    
    
    /*---------------------------------------------------------------Scenario-I------------------------------------------------------*/

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

    
    
    /*----------------------------------Scenario - II----------------------------------------*/
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
        // Write code here that turns the phrase above into concrete actions
    	consultationFormPage = new ConsultationFormPage(driver);
    	Assert.assertTrue(consultationFormPage.EnableContinue());
         
    }

     
 
 
/*-----------------------------Scenario - III -------------------------------------*/

 


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

/*------------------------------Scenario-IV-------------------------------------------------*/

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




/*-------------------------------------------Scenario - V-------------------------------------------------------*/
 

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

@After
public void tearDown(Scenario scenario) // will take screenshots for each and every scenario
{
	final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	 scenario.attach(screenshot, "image/png", "Image");
}

 



}



 
    
     




