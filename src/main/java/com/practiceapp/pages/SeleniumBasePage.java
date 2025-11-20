package com.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class SeleniumBasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public SeleniumBasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void click(By locator) {
        waitForClickable(locator).click();
    }

    protected void type(By locator, String text) {
        waitForVisible(locator).clear();
        waitForVisible(locator).sendKeys(text);
    }

    protected String getText(By locator) {
        return waitForVisible(locator).getText();
    }

    protected boolean isDisplayed(By locator) {
        try {
            return waitForVisible(locator).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected void navigateTo(String url) {
        driver.get(url);
    }
}
