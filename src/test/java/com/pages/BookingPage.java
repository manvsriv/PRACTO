package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public class BookingPage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public BookingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@class,'locationDropdown')]")
    WebElement cityDropdown;
    @FindBy(xpath = "//*[@id='__next']/main/div/div[4]/div[2]/div/div[1]/div[1]/div/div/span[2]/span/img")
    WebElement locationDropdownIcon;

    @FindBy(xpath = "//input[@type='radio']")
    List<WebElement> cityRadioButtons;
    @FindBy(xpath = "//*[@id='__next']/main/div/div[4]/div[2]/div/div[1]/div[2]/div/div/span[2]/span/img")
    WebElement ailmentDropdownIcon;

    @FindBy(xpath = "//div[contains(@class,'ailmentDropdown')]")
    WebElement ailmentDropdown;

    @FindBy(xpath = "//h1[contains(text(),'Ophthamology')]")
    WebElement ophthamologyCategory;

    @FindBy(xpath = "//h1[contains(text(),'Lasik') and contains(@class,'SpecialityWithAilmentSelectorModal-module_ailmentTitle__Lciwm')]")
    WebElement lasikAilment;

    @FindBy(id = "Name-Gen-Lead-Form")
    WebElement nameInput;

    @FindBy(id = "Phone-Gen-Lead-Form")
    WebElement phoneInput;

    @FindBy(css = "button[data-qa-id='book-appointment-cta']")
    WebElement bookAppointmentButton;

    @FindBy(xpath = "//*[contains(text(),'Congratulations') or contains(text(),'Thank you')]")
    WebElement confirmationMessage;

    public void selectCityAsPune() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locationDropdownIcon)).click();
            List<WebElement> radioButtons = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@type='radio']")));
            List<WebElement> labels = driver.findElements(By.xpath("//label"));
            for (WebElement label : labels) {
                System.out.println(" City option: " + label.getText());
            }

            if (radioButtons.size() >= 6) {
                WebElement pune = radioButtons.get(5);
                actions.moveToElement(pune).pause(Duration.ofMillis(300)).click().perform();
                System.out.println("Selected city: Pune");
            } else {
                System.out.println(" Pune not found among city options.");
            }

        } catch (Exception e) {
            System.out.println(" Location selection failed: " + e.getMessage());
        }
    }
    public void selectAilmentAsLasik() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(ailmentDropdownIcon)).click();
            System.out.println(" Ailment dropdown opened.");

            wait.until(ExpectedConditions.visibilityOf(ophthamologyCategory));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ophthamologyCategory);
            System.out.println(" Ophthamology category selected.");

            wait.until(ExpectedConditions.visibilityOf(lasikAilment));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", lasikAilment);
            System.out.println(" Lasik selected.");

            // Optional visual confirmation
            By lasikReflected = By.xpath("//*[contains(text(),'Lasik')]");
            wait.until(ExpectedConditions.visibilityOfElementLocated(lasikReflected));
            System.out.println(" Lasik reflected in form.");
            
        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println(" Ailment selection failed: " + e.getMessage());
        }
    }
    public void searchAndSelectAilment(String keyword) {
        try {
            // Open and interact with the modal search textbox
            By searchBoxLocator = By.xpath("//*[@id='__next']/main/div/div[4]/div[2]/div/div[3]/div/div[2]/div[2]/div/div[1]/div/input");
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBoxLocator));
            searchBox.clear();
            searchBox.sendKeys(keyword);
            System.out.println(" Typed keyword: " + keyword);

            Thread.sleep(1000); // Wait for suggestions to render

            // Locate and select the first matching label
            By labelLocator = By.xpath("//label[contains(@for,'radio')]");
            List<WebElement> labels = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(labelLocator));

            if (!labels.isEmpty()) {
                WebElement firstLabel = labels.get(0);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstLabel);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstLabel);
                System.out.println(" Selected first suggestion label for: " + keyword);
            } else {
                System.out.println("No labels found for radio options after keyword: " + keyword);
            }

            // Confirm with Continue button
            By continueButtonLocator = By.xpath("//button[contains(text(),'Continue') or contains(text(),'Next') or contains(text(),'Submit')]");
            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(continueButtonLocator));
            continueButton.click();
            System.out.println(" Confirmed ailment selection for keyword: " + keyword);

        } catch (Exception e) {
            System.out.println(" Ailment selection failed for '" + keyword + "': " + e.getMessage());
        }
    }
    public void selectAilmentSuggestion(String visibleLabel) {
        try {
            By suggestionsLocator = By.xpath("//div[contains(@class,'itemContent') or contains(@class,'SpecialityWithAilmentSelectorModal-module_itemCard')]");
            List<WebElement> suggestions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(suggestionsLocator));

            for (WebElement suggestion : suggestions) {
                if (suggestion.getText().contains(visibleLabel)) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", suggestion);
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", suggestion);
                    System.out.println(" Selected ailment: " + visibleLabel);
                    break;
                }
            }

            By continueBtn = By.xpath("//button[contains(text(),'Continue') or contains(text(),'Next') or contains(text(),'Submit')]");
            wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
            System.out.println(" Ailment selection confirmed.");

        } catch (Exception e) {
            System.out.println(" Failed to select ailment: " + e.getMessage());
        }
    }
    
    public boolean isMobileNumberErrorDisplayed() {
        By errorLocator = By.xpath("//*[contains(text(),'invalid mobile number') or contains(text(),'Enter a valid')]");
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
    public void enterPatientName(String name) {
        wait.until(ExpectedConditions.visibilityOf(nameInput)).clear();
        nameInput.sendKeys(name);
    }

    public void enterPhoneNumber(String phone) {
        wait.until(ExpectedConditions.visibilityOf(phoneInput)).clear();
        phoneInput.sendKeys(phone);
    }

    public void clickBookAppointment() {
        wait.until(ExpectedConditions.elementToBeClickable(bookAppointmentButton)).click();
        System.out.println(" Appointment form submitted.");
    }

    public boolean isConfirmationDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(confirmationMessage)).isDisplayed();
    }

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }
}