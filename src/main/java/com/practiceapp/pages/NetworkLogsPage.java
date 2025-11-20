package com.example.pages;

import org.openqa.selenium.WebDriver;

public class NetworkLogsPage extends SeleniumBasePage {

    public NetworkLogsPage(WebDriver driver) {
        super(driver);
        navigateTo("http://localhost:8080/network.html");
    }

    // DevTools setup happens inside the test class, not the page
}
