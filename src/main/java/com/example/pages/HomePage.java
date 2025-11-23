package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By welcome = By.id("welcome");
    private final By statusInput = By.id("status-input");
    private final By submitStatus = By.id("submit-status");
    private final By newsletterCheckbox = By.id("newsletter-checkbox");
    private final By subscribeBtn = By.id("subscribe-btn");

    private final String url = "http://localhost:8080/home.html";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getWelcomeMessage() {
        return getText(welcome);
    }

    public HomePage enterStatus(String text) {
        type(statusInput, text);
        return this;
    }

    public HomePage submitStatus() {
        click(submitStatus);
        return this;
    }

    public HomePage toggleNewsletter() {
        click(newsletterCheckbox);
        return this;
    }

    public HomePage clickSubscribe() {
        click(subscribeBtn);
        return this;
    }


    public HomePage load() {
        driver.get(url);
        return this;
    }
}
