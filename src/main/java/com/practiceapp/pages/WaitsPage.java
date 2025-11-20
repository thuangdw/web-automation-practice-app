package com.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WaitsPage extends SeleniumBasePage {

    private final By startBtn = By.id("start-btn");
    private final By loadingIcon = By.id("loading");
    private final By loadedMessage = By.id("loaded-msg");

    public WaitsPage(WebDriver driver) {
        super(driver);
        navigateTo("http://localhost:8080/waits.html");
    }

    public void clickStart() {
        click(startBtn);
    }

    public boolean waitForLoadingToDisappear() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));
        return true;
    }

    public String getLoadedMessage() {
        return getText(loadedMessage);
    }
}
