package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By username = By.id("username");
    private final By password = By.id("password");
    private final By loginBtn = By.id("loginBtn");
    private final By loginMessage = By.id("loginMessage");

    private final String url = "http://localhost:8080/login.html";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage load() {
        driver.get(url);
        return this;
    }

    public LoginPage enterUsername(String username) {
        type(this.username, username);
        return this;
    }

    public LoginPage enterEmail(String e) {
        // Alias for backward compatibility
        return enterUsername(e);
    }

    public LoginPage enterPassword(String p) {
        type(password, p);
        return this;
    }

    public HomePage clickLogin() {
        click(loginBtn);
        return new HomePage(driver);
    }

    public String getLoginMessage() {
        return getText(loginMessage);
    }
}
