package com.practiceapp.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertPage extends BasePage {

    private final By alertButton = By.id("alertBtn");
    private final By confirmButton = By.id("confirmBtn");
    private final By promptButton = By.id("promptBtn");
    private final By resultText = By.id("alertResult");

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    public void triggerAlert() {
        click(alertButton);
    }

    public void triggerConfirm() {
        click(confirmButton);
    }

    public void triggerPrompt(String input) {
        click(promptButton);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(input);
        alert.accept();
    }

    public String getResultText() {
        return getText(resultText);
    }

    public void acceptAlert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public void dismissAlert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
    }
}
