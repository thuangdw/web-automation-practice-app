package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownsPage extends SeleniumBasePage {

    private final By countryDropdown = By.id("country");

    public DropdownsPage(WebDriver driver) {
        super(driver);
    }

    public DropdownsPage selectCountry(String country) {
        Select select = new Select(waitForVisible(countryDropdown));
        select.selectByVisibleText(country);
        return this;
    }
}
