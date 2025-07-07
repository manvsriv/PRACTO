package stepDefination;

import org.openqa.selenium.WebDriver;

//import com.aventstack.extentreports.util.Assert;
import com.pages.BasePage;
import com.pages.ConsultNowPage;
import com.pages.Homepage;
import com.setup.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class VideoConsultSteps
{
	WebDriver driver;
	Homepage homePage;
    ConsultNowPage consultNowPage;
    
    @When("User clicks on Video Consult link from homepage")
    public void user_clicks_on_video_consult_link_from_homepage() {
    	driver=BaseSteps.chromedriver();
    	homePage=new Homepage(driver);
    	homePage.clickVideoConsultLink();
    }

    @When("User Clicks on Consult Now button on Video Consult Page")
    public void user_clicks_on_consult_now_button_on_video_consult_page() {
    	consultNowPage=new ConsultNowPage(driver);
    	consultNowPage.clickConsultNowButton();
    }

    @Then("Consultation form should be displayed successfully")
    public void consultation_form_should_be_displayed_successfully() {
    	
    	Assert.assertTrue(driver.getCurrentUrl().equals("https://www.practo.com/consult/direct/new_consultation"));
    }



    	 
	 

}
