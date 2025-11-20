package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormsPage extends SeleniumBasePage {

    private final By nameField = By.id("name");
    private final By emailField = By.id("email");
    private final By submitBtn = By.id("submit-btn");
    private final By resultText = By.id("result");

    public FormsPage(WebDriver driver) {
        super(driver);
    }

    public FormsPage enterName(String name) {
        type(nameField, name);
        return this;
    }

    public FormsPage enterEmail(String email) {
        type(emailField, email);
        return this;
    }

    public FormsPage submit() {
        click(submitBtn);
        return this;
    }

    public String getResult() {
        return getText(resultText);
    }
}
