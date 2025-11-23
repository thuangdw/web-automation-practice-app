package com.practiceapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NetworkLogsPage extends BasePage {

    private final By fetchBtn = By.id("fetchBtn");

    public NetworkLogsPage(WebDriver driver) {
        super(driver);
    }

    public void clickFetchButton() {
        click(fetchBtn);
    }
}
