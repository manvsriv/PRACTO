package com.pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public class AbdmPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(tagName = "video")
    WebElement videoElement;

    @FindBy(xpath = "//button[contains(text(),'Plan')]")
    WebElement planButton;

    public AbdmPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public boolean isVideoVisible() {
        try {
            return videoElement.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println(" Video element not found.");
            return false;
        }
    }

    public void clickPlanButton() {
        planButton.click();
        System.out.println(" Plan button clicked.");
    }

    public void playEmbeddedYoutubeVideo() {
        By iframeLocator = By.cssSelector("iframe[src*='youtube.com']");
        WebElement videoFrame = wait.until(ExpectedConditions.presenceOfElementLocated(iframeLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", videoFrame);
        driver.switchTo().frame(videoFrame);

        By playBtn = By.cssSelector("button[aria-label='Play'], div.ytp-large-play-button");
        WebElement play = wait.until(ExpectedConditions.elementToBeClickable(playBtn));
        play.click();
        System.out.println("▶️ YouTube video playback triggered.");
        driver.switchTo().defaultContent();
    }
}