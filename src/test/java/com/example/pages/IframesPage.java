package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IframesPage extends SeleniumBasePage {

    private final By iframeLocator = By.id("frame1");
    private final By frameText = By.id("frame-text");

    public IframesPage(WebDriver driver) {
        super(driver);
    }

    public String readTextInsideFrame() {
        switchToFrame(iframeLocator);
        String text = getText(frameText);
        switchToDefault();
        return text;
    }
}
