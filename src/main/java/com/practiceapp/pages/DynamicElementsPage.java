package com.example.pages;

import org.openqa.selenium.*;

public class DynamicElementsPage extends SeleniumBasePage {

    private final By generateBtn = By.id("generate");
    private final By dynamicText = By.id("dynamic");

    public DynamicElementsPage(WebDriver driver) {
        super(driver);
        navigateTo("http://localhost:8080/dynamic.html");
    }

    public void clickGenerate() {
        click(generateBtn);
    }

    public String getDynamicText() {
        return getText(dynamicText);
    }
}
