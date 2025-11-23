package com.practiceapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class MultipleWindowsPage extends BasePage {

    private final By openNewTabBtn = By.id("newTab");

    public MultipleWindowsPage(WebDriver driver) {
        super(driver);
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
