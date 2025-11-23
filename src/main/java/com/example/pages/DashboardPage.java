package com.practiceapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    // Locators
    private final By welcomeMessage = By.id("welcomeMsg");
    private final By logoutBtn = By.id("logoutBtn");
    private final By profileLink = By.id("profileLink");
    private final By settingsLink = By.id("settingsLink");
    private final By searchField = By.id("searchInput");
    private final By searchBtn = By.id("searchBtn");

    // Constructor
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    // Actions
    public String getWelcomeMessage() {
        return getText(welcomeMessage);
    }

    public LoginPage clickLogout() {
        click(logoutBtn);
        return new LoginPage(driver);
    }

    public ProfilePage goToProfile() {
        click(profileLink);
        return new ProfilePage(driver);
    }

    public SettingsPage goToSettings() {
        click(settingsLink);
        return new SettingsPage(driver);
    }

    public SearchResultsPage search(String query) {
        type(searchField, query);
        click(searchBtn);
        return new SearchResultsPage(driver);
    }
}
