package com.example.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertsPage extends BasePage {

    private final By alertBtn = By.xpath("//button[text()='Simple Alert']");
    private final By confirmBtn = By.xpath("//button[text()='Confirm Alert']");
    private final By promptBtn = By.xpath("//button[text()='Prompt Alert']");
    private final By result = By.id("result");
    private final String url = "http://localhost:8080/alert.html";

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public AlertsPage load() {
        driver.get(url);
        return this;
    }

    public String clickAlertAndAccept() {
        click(alertBtn);
        Alert a = wait.until(ExpectedConditions.alertIsPresent());
        String text = a.getText();
        a.accept();
        return text;
    }

    public String clickPromptAndSend(String textToSend) {
        click(promptBtn);
        Alert a = wait.until(ExpectedConditions.alertIsPresent());
        a.sendKeys(textToSend);
        a.accept();
        return textToSend;
    }

    public String getResult() {
        return getText(result);
    }

    public String clickConfirmAndAccept() {
        click(confirmBtn);
        Alert a = wait.until(ExpectedConditions.alertIsPresent());
        String text = a.getText();
        a.accept();
        return text;
    }

    public String clickConfirmAndDismiss() {
        click(confirmBtn);
        Alert a = wait.until(ExpectedConditions.alertIsPresent());
        String text = a.getText();
        a.dismiss();
        return text;
    }
}
