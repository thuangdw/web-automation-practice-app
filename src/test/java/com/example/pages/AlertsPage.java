package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage extends SeleniumBasePage {

    private final By alertButton = By.id("alert-btn");
    private final By confirmButton = By.id("confirm-btn");
    private final By promptButton = By.id("prompt-btn");

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public AlertsPage clickAlert() {
        click(alertButton);
        acceptAlert();
        return this;
    }

    public AlertsPage clickConfirmAccept() {
        click(confirmButton);
        acceptAlert();
        return this;
    }

    public AlertsPage clickPrompt(String input) {
        click(promptButton);
        driver.switchTo().alert().sendKeys(input);
        acceptAlert();
        return this;
    }
}
