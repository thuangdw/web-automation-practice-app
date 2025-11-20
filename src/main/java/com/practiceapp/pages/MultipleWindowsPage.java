package com.example.pages;

import org.openqa.selenium.*;

import java.util.Set;

public class MultipleWindowsPage extends SeleniumBasePage {

    private final By openNewTabBtn = By.id("open-tab");

    public MultipleWindowsPage(WebDriver driver) {
        super(driver);
        navigateTo("http://localhost:8080/windows.html");
    }

    public void openNewTab() {
        click(openNewTabBtn);
    }

    public void switchToNewTab() {
        String main = driver.getWindowHandle();
        Set<String> all = driver.getWindowHandles();

        for (String w : all) {
            if (!w.equals(main)) {
                driver.switchTo().window(w);
                return;
            }
        }
    }
}
