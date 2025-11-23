package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WaitsPage extends BasePage {

    private final By loadBtn = By.id("loadBtn");
    private final By loadingMessage = By.id("loadingMessage");
    private final String url = "http://localhost:8080/waits.html";

    public WaitsPage(WebDriver driver) {
        super(driver);
    }

    public WaitsPage load() {
        driver.get(url);
        return this;
    }

    public void clickLoadButton() {
        click(loadBtn);
    }

    public String getLoadingMessage() {
        return getText(loadingMessage);
    }

    public String waitForDelayedText() {
        // Alias for backward compatibility
        clickLoadButton();
        waitForInvisibility(loadBtn);
        return getLoadingMessage();
    }
}
