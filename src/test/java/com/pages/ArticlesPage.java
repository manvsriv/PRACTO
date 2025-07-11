package com.pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public class ArticlesPage extends BasePage {

    public ArticlesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

   
    public void selectHealthyEatingTab() {
    	By healthyEatingTab = By.xpath("//span[text()='Healthy Eating']");
    	WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(healthyEatingTab));
        scrollToElement(tab);
        tab.click();
        System.out.println(" Healthy Eating tab clicked.");

    }

    public void captureOpenedArticleScreenshot(String filename) throws IOException {
        By articleHeader = By.cssSelector("h2.horizontal-card-title"); // Wait for article to load
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(articleHeader));
        System.out.println("📖 Article loaded with title: " + header.getText());

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("screenshots/" + filename + ".png");
        FileUtils.copyFile(src, dest);
        System.out.println("📸 Screenshot saved: " + dest.getAbsolutePath());
    }
//    public void selectHealthyEatingTab() {
//        By healthyEatingTab = By.xpath("//span[text()='Healthy Eating']");
//
//        try {
//            // Wait for tab to be present before locating it
//            wait.until(ExpectedConditions.presenceOfElementLocated(healthyEatingTab));
//            WebElement tab = driver.findElement(healthyEatingTab); // fresh reference
//            scrollToElement(tab);
//            wait.until(ExpectedConditions.elementToBeClickable(tab)).click();
//            System.out.println("Healthy Eating tab clicked.");
//        } catch (StaleElementReferenceException stale) {
//            System.out.println(" Stale element detected. Re-fetching Healthy Eating tab...");
//            WebElement refreshedTab = wait.until(ExpectedConditions.elementToBeClickable(healthyEatingTab));
//            scrollToElement(refreshedTab);
//            refreshedTab.click();
//            System.out.println("Healthy Eating tab clicked after refresh.");
//        } catch (Exception e) {
//            System.out.println("Failed to click Healthy Eating tab: " + e.getMessage());
//        }
//    }
    public void clickHealthyEatingArticle() {
        // Use the anchor tag instead of span for better click reliability
        By healthyEatingArticle = By.xpath("//*[@id='feedContentContainer']/div/div/div[1]/div[2]/div/div/div/div[3]/div[2]/a");

        WebElement article = wait.until(ExpectedConditions.elementToBeClickable(healthyEatingArticle));
        scrollToElement(article);
        article.click();
        System.out.println(" Clicked on Healthy Eating article.");
    }
//    public void clickHealthyEatingArticle() {
//        try {
//            // More flexible selector to target any article anchor in Healthy Eating tab
//            By articleLinkLocator = By.cssSelector("#feedContentContainer a[href*='/article']");
//
//            // Wait for article list to load fully
//            List<WebElement> articles = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(articleLinkLocator));
//
//            if (!articles.isEmpty()) {
//                WebElement firstArticle = articles.get(0);
//                scrollToElement(firstArticle);
//                wait.until(ExpectedConditions.elementToBeClickable(firstArticle)).click();
//
//                System.out.println("✅ Clicked Healthy Eating article.");
//                System.out.println("🧭 Navigated to: " + driver.getCurrentUrl());
//            } else {
//                System.out.println("❌ No articles found in Healthy Eating section.");
//            }
//
//        } catch (TimeoutException e) {
//            System.out.println("⏳ Timeout while loading article list: " + e.getMessage());
//        } catch (Exception e) {
//            System.out.println("⚠️ Unexpected error: " + e.getMessage());
//        }
//    }
}