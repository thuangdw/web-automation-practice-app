package com.practiceapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "username") private WebElement usernameInput;
    @FindBy(id = "password") private WebElement passwordInput;
    @FindBy(id = "loginBtn") private WebElement loginButton;
    @FindBy(id = "errorMsg") private WebElement errorMsg;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage enterUsername(String username) {
        type(usernameInput, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        type(passwordInput, password);
        return this;
    }

    public DashboardPage clickLogin() {
        click(loginButton);
        return new DashboardPage(driver);
    }

    public String getErrorMessage() {
        return getText(errorMsg);
    }
}
