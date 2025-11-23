package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowsPage extends BasePage {

    private final By newTabButton = By.xpath("//button[text()='Open New Tab']");
    private final String url = "http://localhost:8080/windows-tabs.html";

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    public WindowsPage load() {
        driver.get(url);
        return this;
    }

    public void openNewTabAndSwitch() {
        String main = driver.getWindowHandle();
        click(newTabButton);
        Set<String> handles = driver.getWindowHandles();
        for (String h : handles) {
            if (!h.equals(main)) {
                driver.switchTo().window(h);
                return;
            }
        }
    }

    public void switchBackToMain(String mainHandle) {
        driver.switchTo().window(mainHandle);
    }
}
