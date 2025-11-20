package com.example.pages;

import org.openqa.selenium.*;

public class StaleElementPage extends SeleniumBasePage {

    private final By updateButton = By.id("update");
    private final By dynamicElement = By.id("dynamic-element");

    public StaleElementPage(WebDriver driver) {
        super(driver);
        navigateTo("http://localhost:8080/stale.html");
    }

    public String getDynamicTextWithRetry() {
        for (int i = 0; i < 3; i++) {
            try {
                return waitForVisible(dynamicElement).getText();
            } catch (StaleElementReferenceException e) {
                waitForVisible(dynamicElement);
            }
        }
        throw new RuntimeException("Stale element could not be resolved after retries.");
    }

    public void clickUpdate() {
        click(updateButton);
    }
}
