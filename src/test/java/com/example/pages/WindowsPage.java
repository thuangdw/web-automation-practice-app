package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowsPage extends SeleniumBasePage {

    private final By openWindowBtn = By.id("open-window-btn");

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    public String switchToNewWindow() {
        String original = driver.getWindowHandle();
        click(openWindowBtn);

        Set<String> handles = driver.getWindowHandles();
        for (String h : handles) {
            if (!h.equals(original)) {
                driver.switchTo().window(h);
                return driver.getTitle();
            }
        }
        return null;
    }
}
