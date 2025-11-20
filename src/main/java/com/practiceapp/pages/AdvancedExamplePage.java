package com.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

public class AdvancedExamplePage extends SeleniumBasePage {

    // -------------------------------------------
    // Locators
    // -------------------------------------------
    private By dynamicButton = By.id("dynamicBtn");
    private By drag = By.id("drag");
    private By drop = By.id("drop");
    private By iframe = By.id("practice-iframe");
    private By shadowHost = By.cssSelector("custom-shadow-widget");

    private By emailField = By.xpath("//input[contains(@placeholder,'email')]");

    // Stale-prone element
    private By staleElement = By.id("staleElement");

    public AdvancedExamplePage(WebDriver driver) {
        super(driver);
    }

    // -------------------------------------------
    // Page Actions
    // -------------------------------------------

    public AdvancedExamplePage clickDynamicButton() {
        safeClick(dynamicButton);
        return this;
    }

    public AdvancedExamplePage enterEmail(String email) {
        type(emailField, email);
        return this;
    }

    public AdvancedExamplePage performDragDrop() {
        dragAndDrop(drag, drop);
        return this;
    }

    // iframe interaction
    public AdvancedExamplePage interactWithIframe() {
        switchToFrame(iframe);

        // inside iframe
        click(By.id("iframeBtn"));

        switchToDefault();
        return this;
    }

    // shadow DOM interaction
    public AdvancedExamplePage interactWithShadowDom() {
        WebElement host = find(shadowHost);
        WebElement shadowRoot = expandShadowRoot(host);

        WebElement innerButton = shadowRoot.findElement(By.cssSelector("#innerShadowBtn"));
        innerButton.click();

        return this;
    }

    // stale element handling
    public AdvancedExamplePage clickStaleElement() {
        safeClick(staleElement);
        return this;
    }

    // complex dynamic table
    public String getCellValue(int row, int col) {
        By cellLocator = By.xpath("//table[@id='dataTable']/tbody/tr[" + row + "]/td[" + col + "]");
        return getText(cellLocator);
    }

    // JS operations
    public AdvancedExamplePage highlightElements() {
        js("document.querySelector('#dynamicBtn').style.border='3px solid red'");
        return this;
    }
}
