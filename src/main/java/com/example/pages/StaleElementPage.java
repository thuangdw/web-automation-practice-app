package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

public class StaleElementPage extends BasePage {

    private final By textElement = By.id("text");
    private final By updateButton = By.xpath("//button[text()='Update Text']");
    private final String url = "http://localhost:8080/stale-elements.html";

    public StaleElementPage(WebDriver driver) {
        super(driver);
    }

    public StaleElementPage load() {
        driver.get(url);
        return this;
    }

    public String getTextWithRetry() {
        for (int i = 0; i < 3; i++) {
            try {
                return getText(textElement);
            } catch (StaleElementReferenceException e) {
                if (i == 2) throw e;
                // Wait a bit and retry
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        throw new RuntimeException("Stale element could not be resolved after retries.");
    }

    public void clickUpdateButton() {
        click(updateButton);
    }

    public String getTextElement() {
        return getText(textElement);
    }
}
