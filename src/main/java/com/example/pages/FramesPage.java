package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage extends BasePage {

    private final By frame = By.id("testFrame");
    private final By frameInput = By.id("insideInput");
    private final String url = "http://localhost:8080/iframe.html";

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    public FramesPage load() {
        driver.get(url);
        return this;
    }

    public void typeInFrame(String text) {
        driver.switchTo().frame(find(frame));
        type(frameInput, text);
        driver.switchTo().defaultContent();
    }
}
