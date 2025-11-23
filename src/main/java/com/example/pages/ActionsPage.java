package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsPage extends BasePage {

    private final By source = By.id("drag");
    private final By target = By.id("drop");
    private final String url = "http://localhost:8080/drag-drop.html";

    public ActionsPage(WebDriver driver) {
        super(driver);
    }

    public ActionsPage load() {
        driver.get(url);
        return this;
    }

    public ActionsPage dragAndDrop() {
        WebElement s = find(source);
        WebElement t = find(target);
        actions.dragAndDrop(s, t).perform();
        return this;
    }
}
