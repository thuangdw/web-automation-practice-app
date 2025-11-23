package com.practiceapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IframePage extends BasePage {

    private final By iframe = By.id("testFrame");
    private final By iframeInput = By.id("iframeInput");

    public IframePage(WebDriver driver) {
        super(driver);
    }

    public void switchToFrame() {
        driver.switchTo().frame(find(iframe));
    }

    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    public void enterTextInIframe(String text) {
        switchToFrame();
        type(iframeInput, text);
        switchToDefault();
    }

    public String getIframeInputValue() {
        switchToFrame();
        String value = find(iframeInput).getAttribute("value");
        switchToDefault();
        return value;
    }
}

