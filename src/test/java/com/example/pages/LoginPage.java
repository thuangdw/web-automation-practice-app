package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends SeleniumBasePage {

    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-btn");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterEmail(String email) {
        type(emailField, email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        type(passwordField, password);
        return this;
    }

    public HomePage clickLogin() {
        click(loginButton);
        return new HomePage(driver);
    }
}
