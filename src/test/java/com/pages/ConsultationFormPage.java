package com.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 

public class ConsultationFormPage extends BasePage {

    @FindBy(name = "detailedDescription")
    WebElement symptomInput;

    @FindBy(xpath = "//label[contains(text(),'Pediatrics')]")
    WebElement specialityOption;

    @FindBy(css="div.wrapper-with-nav")
    WebElement scrollContainer;
    
    @FindBy(name = "mobileInteraction")
    WebElement mobileNumberInput;

    @FindBy(css = "button.continue-btn")
    WebElement continueButton;

   
    @FindBy(xpath="//label[contains(text(),'Pediatrics'")
    WebElement speciality;
    
    public ConsultationFormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterSymptom(String symptom) {
        waitUntilWebElementIsVisible(symptomInput);
        waitUntilElementIsClickable(symptomInput);
        symptomInput.clear();
        symptomInput.sendKeys(symptom);
    }

    public void selectSpeciality() {
        waitUntilWebElementIsVisible(specialityOption);
        waitUntilElementIsClickable(specialityOption);
        specialityOption.click();
    }
    

    public void scrollToMobileInput() {
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", 
            mobileNumberInput
        );
    }


    public void enterMobileNumber(String mobileNumber) {
        waitUntilWebElementIsVisible(mobileNumberInput);
        waitUntilElementIsClickable(mobileNumberInput);
        mobileNumberInput.clear();
        mobileNumberInput.sendKeys(mobileNumber);
    }

 
    public boolean EnableContinue() {
        waitUntilWebElementIsVisible(continueButton);
        return continueButton.isEnabled();
    }
    
 // Scroll to top using Robot
    public void scrollToTopUsingRobot() {
        try {
            Robot robot = new Robot();
            for (int i = 0; i < 5; i++) {
                robot.keyPress(KeyEvent.VK_PAGE_UP);
                robot.keyRelease(KeyEvent.VK_PAGE_UP);
                
                Thread.sleep(300);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickPractoLogoUsingActions() {
        WebElement logo = driver.findElement(By.xpath("//a[@href='https://www.practo.com' and contains(@class,'ng-scope')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(logo).click().perform();
    }

  
  
}

