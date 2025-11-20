package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShadowDomPage extends SeleniumBasePage {

    private final By shadowHost = By.id("shadow-host");
    private final By shadowText = By.cssSelector("#shadow-text");

    public ShadowDomPage(WebDriver driver) {
        super(driver);
    }

    public String readShadowContent() {
        WebElement host = waitForVisible(shadowHost);
        SearchContext shadowRoot = host.getShadowRoot();
        return shadowRoot.findElement(shadowText).getText();
    }
}
