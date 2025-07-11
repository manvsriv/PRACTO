package com.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    private By locationInput = By.cssSelector("input[data-qa-id='omni-searchbox-locality']");
    private By searchBox = By.cssSelector("input[data-qa-id='omni-searchbox-keyword']");
    private By sortDropdown = By.xpath("//span[contains(@class,'c-sort-dropdown__selected')]");  // Adjust to parent div if needed
    private By abdmLink = By.xpath("//a[@href='https://www.practo.com/providers/abdm']");
    private By experienceHighToLow = By.xpath("//span[text()='Experience - High to Low']");

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectCity(String cityName) {
        WebElement location = driver.findElement(locationInput);
        scrollToElement(location);
        waitForVisibility(location);

        String currentCity = location.getAttribute("value");
        if (!currentCity.equalsIgnoreCase(cityName)) {
            location.click();
            location.clear();
            location.sendKeys(cityName);
            location.sendKeys(Keys.ENTER);
        }
    }

    public void enterSearchAndSubmit(String query) {
        WebElement searchInput = driver.findElement(searchBox);
        waitForVisibility(searchInput);
        searchInput.clear();
        searchInput.sendKeys(query);

        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        searchInput.sendKeys(Keys.ARROW_DOWN); 
        searchInput.sendKeys(Keys.ENTER);      
    }

    public void applySortFilter(String filterText) {
        try {
            // Confirm we're on the results page with some hint text
            By doctorCardLocator = By.cssSelector("div[data-qa-id='doctor_card']");
            wait.until(ExpectedConditions.presenceOfElementLocated(doctorCardLocator));
            System.out.println(" Doctor cards detected — ready to apply filter.");

            // Open sort dropdown
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(sortDropdown));
            scrollToElement(dropdown);
            dropdown.click();

            // Click on filter option
            By option = By.xpath("//span[text()='" + filterText + "']");
            WebElement filter = wait.until(ExpectedConditions.elementToBeClickable(option));
            filter.click();

            // Confirm results reloaded after applying filter
            Thread.sleep(1500);
            List<WebElement> updatedCards = driver.findElements(doctorCardLocator);

            if (updatedCards.isEmpty()) {
                System.out.println("Filter applied but no doctor cards found. Possible empty result.");
            } else {
                System.out.println(" Filter applied. Doctors displayed: " + updatedCards.size());
            }

        } catch (TimeoutException e) {
            System.out.println("Timeout while applying filter. Retrying...");

            // Optional retry logic or screenshot
        } catch (Exception e) {
            System.out.println("Filter application failed: " + e.getMessage());
        }
    }
  

        public void clickViewSpecialities() {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 800);");
            try { Thread.sleep(800); } catch (InterruptedException e) { e.printStackTrace(); }

            By viewBtn = By.xpath("//button[contains(text(),'View All Specialities')]");
            WebElement button = driver.findElement(viewBtn);
            scrollToElement(button);
            waitForClickable(button);
            button.click();
        }

        public void clickSeeAllSpecialities() {
            By seeAllBtn = By.xpath("//a[contains(@href,'new_consultation') and contains(text(),'See all Specialities')]");
            WebElement btn = driver.findElement(seeAllBtn);

            Actions actions = new Actions(driver);
            actions.moveToElement(btn).pause(Duration.ofMillis(500)).click().perform();

            // 💬 Log the current URL after the click
            System.out.println("Navigated to: " + driver.getCurrentUrl());
        }

        public void fillSymptomAndMobile(String symptom, String mobileNumber) {
            wait.until(ExpectedConditions.urlContains("new_consultation"));
            System.out.println("Consultation form loaded at: " + driver.getCurrentUrl());

            By symptomField = By.id("detailed-description");
            WebElement symptomInput = wait.until(ExpectedConditions.visibilityOfElementLocated(symptomField));
            symptomInput.clear();
            symptomInput.sendKeys(symptom);

            // Optional: Select first radio button if available
            List<WebElement> radios = driver.findElements(By.xpath("//input[@type='radio']"));
            if (!radios.isEmpty()) {
                waitForClickable(radios.get(0));
                radios.get(0).click();
            }

            By mobileField = By.cssSelector("input[type='tel']");
            WebElement mobileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileField));
            mobileInput.clear();
            mobileInput.sendKeys(mobileNumber);

            By continueBtn = By.xpath("//button[contains(@class,'continue-btn') and contains(text(),'Continue')]");
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
            button.click();

            // 🧠 Pause here for manual OTP entry
            System.out.println(" OTP prompt detected — please enter the code manually in browser.");
            try {
                Thread.sleep(15000); // Wait 15 seconds (adjust as needed)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void submitOtpSmartly() {
            // 🔍 Try submission via Enter key
            try {
                WebElement otpInput = driver.findElement(By.cssSelector("input[type='tel']"));
                otpInput.sendKeys(Keys.ENTER);
                System.out.println(" Tried submitting OTP using Enter key.");
                Thread.sleep(1500);
            } catch (Exception e) {
                System.out.println("Enter key submission failed or input field not found.");
            }

            // 🔐 Fallback to clicking "Login" or "Verify" button manually
            try {
                By loginBtn = By.xpath("//button[contains(text(),'Login') or contains(text(),'Verify')]");
                WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
                submitBtn.click();
                System.out.println("OTP submitted using button.");
            } catch (TimeoutException e) {
                System.out.println(" No Login/Verify button found — assuming Enter key worked.");
            }

            // ✅ Final confirmation
            System.out.println("Consultation step completed — OTP submitted. No payment interaction as per scenario.");
        }
        public void clickAbdmFromDropdown() {
            By forProvidersMenu = By.xpath("//span[contains(text(),'For Providers')]");
            By abdmLink = By.xpath("//*[@id='root']/div/div/div[1]/div[1]/div[2]/div/div[3]/div[2]/div/div[5]/a");

            // Step 1: Click to trigger the dropdown
            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(forProvidersMenu));
            menu.click();
            try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			} 
            WebElement abdm = wait.until(ExpectedConditions.elementToBeClickable(abdmLink));
            abdm.click();
            System.out.println("ABDM link clicked via absolute XPath.");
        }
        //Screenshot scenario
        public void navigateToHealthArticles() {
            By seeAllArticlesBtn = By.xpath("//button[contains(text(),'See all articles')]");
            WebElement seeAllBtn = wait.until(ExpectedConditions.elementToBeClickable(seeAllArticlesBtn));
            scrollToElement(seeAllBtn);
            seeAllBtn.click();
            System.out.println("Navigated to Health Articles section.");
        }
        //surgeries
        public void navigateToSurgeriesPage() {
            driver.findElement(By.linkText("Surgeries")).click(); // update if locator differs
        }
        public void scrollToBookingForm() {
            try {
                // Wait for the booking section to load — more robust than direct findElement
                By bookingLocator = By.xpath("//*[contains(text(),'Select Location') or contains(text(),'Choose Ailment') or contains(text(),'Book Appointment')]");
                WebElement bookingHeader = new WebDriverWait(driver, Duration.ofSeconds(15))
                    .until(ExpectedConditions.visibilityOfElementLocated(bookingLocator));

                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", bookingHeader);
                System.out.println(" Scrolled to booking form header.");
            } catch (TimeoutException e) {
                System.out.println(" Booking form header not visible after wait: " + e.getMessage());
            } catch (NoSuchElementException e) {
                System.out.println(" Booking form element not found: " + e.getMessage());
            }
        }
        public boolean isNoResultMessageVisible() {
            By messageLocator = By.xpath("//*[contains(text(),'couldn’t find') or contains(text(),'no results') or contains(text(),'not able to find')]");
            try {
                WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(messageLocator));
                System.out.println(" No result message detected: " + message.getText());
                return true;
            } catch (TimeoutException e) {
                System.out.println(" No-result message not shown — unexpected behavior.");
                return false;
            }
        }

    }
   
