package com.practiceapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IframePage extends BasePage {

    private final By iframeOuter = By.id("outerFrame");
    private final By iframeInner = By.id("innerFrame");
    private final By innerText = By.id("innerText");

    public IframePage(WebDriver driver) {
        super(driver);
    }

    public void switchToOuterFrame() {
        driver.switchTo().frame(find(iframeOuter));
    }

    public void switchToInnerFrame() {
        driver.switchTo().frame(find(iframeInner));
    }

    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    public String getInnerText() {
        return getText(innerText);
    }
}
