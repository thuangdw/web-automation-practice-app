package com.practiceapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicDataPage extends BasePage {

    // Locators
    private final By header = By.tagName("h2");

    private final By dynamicText = By.id("dynamicText");
    private final By reloadBtn = By.id("reloadBtn");

    // Constructor
    public DynamicDataPage(WebDriver driver) {
        super(driver);
    }

    // Actions
    public String getHeader() {
        return getText(header);
    }

    public String getDynamicText() {
        return getText(dynamicText);
    }

    public void reloadDynamicText() {
        click(reloadBtn);
        waitForVisible(dynamicText);
    }
}
