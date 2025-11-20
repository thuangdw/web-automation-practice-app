package com.practiceapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage {

    // Locators
    private final By header = By.tagName("h2");
    private final By nameField = By.id("name");
    private final By emailField = By.id("email");
    private final By phoneField = By.id("phone");
    private final By bioTextArea = By.id("bio");
    private final By saveBtn = By.id("saveProfileBtn");
    private final By cancelBtn = By.id("cancelBtn");

    // Constructor
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    // Actions
    public String getHeaderText() {
        return getText(header);
    }

    public void updateName(String name) {
        type(nameField, name);
    }

    public void updateEmail(String email) {
        type(emailField, email);
    }

    public void updatePhone(String phone) {
        type(phoneField, phone);
    }

    public void updateBio(String bio) {
        type(bioTextArea, bio);
    }

    public void saveProfile() {
        click(saveBtn);
    }

    public DashboardPage cancel() {
        click(cancelBtn);
        return new DashboardPage(driver);
    }
}
