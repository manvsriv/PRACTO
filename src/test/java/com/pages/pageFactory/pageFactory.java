package com.pages.pageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pageFactory {
	   WebDriver driver;
	   
	    // Constructor
	    public pageFactory(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);  // Initialize all elements
	    }
	 
	    // Web elements using @FindBy
	    @FindBy(name = "q")
	    WebElement searchInput;
	 
	    @FindBy(id = "city-selector")
	    WebElement citySelector;
	 
	    @FindBy(xpath = "//li[text()='Mumbai']")
	    WebElement cityMumbai;
	 
	    @FindBy(xpath = "//button[contains(text(),'Consult Now')]")
	    WebElement consultNowButton;
	 
	    @FindBy(xpath = "//footer")
	    WebElement footerSection;
	 
	    // Actions
	 
	    public void enterSearchKeyword(String keyword) {
	        searchInput.clear();
	        searchInput.sendKeys(keyword);
	    }
	 
	    public void selectCity() {
	citySelector.click();
	cityMumbai.click();
	    }
	 
	    public void clickConsultNow() {
	consultNowButton.click();
	    }
	 
	    public boolean isFooterVisible() {
	        return footerSection.isDisplayed();
	    }
	 
	    public String getTitle() {
	        return driver.getTitle();
	    }
}
