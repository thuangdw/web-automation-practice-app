package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends SeleniumBasePage {

    private final By welcomeHeader = By.id("welcome");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getWelcomeMessage() {
        return getText(welcomeHeader);
    }
}
