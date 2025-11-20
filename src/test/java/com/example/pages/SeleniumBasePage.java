package com.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class SeleniumBasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public SeleniumBasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
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

    protected void switchToFrame(By locator) {
        WebElement frame = waitForVisible(locator);
        driver.switchTo().frame(frame);
    }

    protected void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    protected void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    protected void dismissAlert() {
        wait.until(ExpectedConditions.alertIsPresent()).dismiss();
    }

    protected void uploadFile(By locator, String filePath) {
        driver.findElement(locator).sendKeys(filePath);
    }
}
