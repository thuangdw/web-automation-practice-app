package com.practiceapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage extends BasePage {

    // Locators
    private final By header = By.tagName("h2");

    private final By nameField = By.id("name");
    private final By emailField = By.id("email");
    private final By countryDropdown = By.id("country");

    private final By subscribeCheckbox = By.id("subscribe");
    private final By genderMaleRadio = By.id("genderMale");
    private final By genderFemaleRadio = By.id("genderFemale");

    private final By messageBox = By.id("message");
    private final By submitBtn = By.id("submitBtn");
    private final By successMsg = By.id("successMessage");

    // Constructor
    public FormPage(WebDriver driver) {
        super(driver);
    }

    // Actions
    public String getHeaderText() {
        return getText(header);
    }

    public void enterName(String name) {
        type(nameField, name);
    }

    public void enterEmail(String email) {
        type(emailField, email);
    }

    public void selectCountry(String country) {
        selectDropdownByVisibleText(countryDropdown, country);
    }

    public void setSubscription(boolean subscribe) {
        if (subscribe) {
            click(subscribeCheckbox);
        }
    }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            click(genderMaleRadio);
        } else if (gender.equalsIgnoreCase("female")) {
            click(genderFemaleRadio);
        }
    }

    public void enterMessage(String message) {
        type(messageBox, message);
    }

    public void submitForm() {
        click(submitBtn);
        waitForVisible(successMsg);
    }

    public String getSuccessMessage() {
        return getText(successMsg);
    }
}
