package com.practiceapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShadowDomPage extends BasePage {

    // Host element for Shadow DOM
    private final By shadowHost = By.cssSelector("#shadow-host");

    // Selectors *inside* shadow root
    private final By shadowInput = By.cssSelector("#shadow-input");
    private final By shadowButton = By.cssSelector("#shadow-btn");
    private final By shadowResult = By.cssSelector("#shadow-result");

    public ShadowDomPage(WebDriver driver) {
        super(driver);
    }

    private SearchContext getShadowRoot() {
        WebElement host = find(shadowHost);
        return (SearchContext) ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("return arguments[0].shadowRoot", host);
    }

    public void enterShadowText(String text) {
        getShadowRoot().findElement(shadowInput).sendKeys(text);
    }

    public void clickShadowButton() {
        getShadowRoot().findElement(shadowButton).click();
    }

    public String getShadowResult() {
        return getShadowRoot().findElement(shadowResult).getText();
    }
}
