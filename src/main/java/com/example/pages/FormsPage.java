package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FormsPage extends BasePage {

    private final By name = By.id("name");
    private final By email = By.id("email");
    private final By message = By.id("message");
    private final By submit = By.id("submitBtn");
    private final By result = By.id("formResult");

    private final String url = "http://localhost:8080/forms.html";

    public FormsPage(WebDriver driver) {
        super(driver);
    }

    public FormsPage load() {
        driver.get(url);
        return this;
    }

    public FormsPage enterName(String n) {
        type(name, n);
        return this;
    }

    public FormsPage enterEmail(String e) {
        type(email, e);
        return this;
    }

    public FormsPage enterMessage(String msg) {
        type(message, msg);
        return this;
    }

    public FormsPage submit() {
        click(submit);
        return this;
    }

    public String getResult() {
        return getText(result);
    }
}
