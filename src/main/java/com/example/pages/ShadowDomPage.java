package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShadowDomPage extends BasePage {

    // Host element for Shadow DOM
    private final By shadowHost = By.cssSelector("#shadow-host");

    // Selectors *inside* shadow root
    private final By shadowText = By.cssSelector("#shadowText");
    private final By shadowBtn = By.cssSelector("#shadowBtn");
    private final String url = "http://localhost:8080/shadow-dom.html";

    public ShadowDomPage(WebDriver driver) {
        super(driver);
    }

    public ShadowDomPage load() {
        driver.get(url);
        return this;
    }

    private SearchContext getShadowRoot() {
        WebElement host = find(shadowHost);
        return (SearchContext) ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("return arguments[0].shadowRoot", host);
    }

    public String getShadowText() {
        return getShadowRoot().findElement(shadowText).getText();
    }

    public void clickShadowButton() {
        getShadowRoot().findElement(shadowBtn).click();
    }
}
