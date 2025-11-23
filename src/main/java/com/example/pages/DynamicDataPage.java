package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicDataPage extends BasePage {

    private final By loadButton = By.xpath("//button[text()='Load New Content']");
    private final By contentBox = By.id("contentBox");
    private final String url = "http://localhost:8080/dynamic-content.html";

    public DynamicDataPage(WebDriver driver) {
        super(driver);
    }

    public DynamicDataPage load() {
        driver.get(url);
        return this;
    }

    public void clickLoadButton() {
        click(loadButton);
    }

    public String getContentBoxText() {
        return getText(contentBox);
    }
}
