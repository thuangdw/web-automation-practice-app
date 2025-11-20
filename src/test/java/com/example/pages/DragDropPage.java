package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DragDropPage extends SeleniumBasePage {

    private final By source = By.id("drag-source");
    private final By target = By.id("drop-target");

    public DragDropPage(WebDriver driver) {
        super(driver);
    }

    public DragDropPage dragAndDrop() {
        WebElement src = waitForVisible(source);
        WebElement tgt = waitForVisible(target);
        actions.dragAndDrop(src, tgt).perform();
        return this;
    }
}
