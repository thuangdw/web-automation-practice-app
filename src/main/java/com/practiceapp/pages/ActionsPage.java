package com.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class ActionsPage extends SeleniumBasePage {

    private final By source = By.id("drag-source");
    private final By target = By.id("drag-target");
    private final By hoverMenu = By.id("menu");
    private final By hoverItem = By.id("submenu-item");
    private final By rightClickArea = By.id("right-click-area");

    private final Actions actions;

    public ActionsPage(WebDriver driver) {
        super(driver);
        navigateTo("http://localhost:8080/actions.html");
        actions = new Actions(driver);
    }

    public void dragAndDrop() {
        actions.dragAndDrop(waitForVisible(source), waitForVisible(target)).perform();
    }

    public void hoverMenuItem() {
        actions.moveToElement(waitForVisible(hoverMenu))
                .moveToElement(waitForVisible(hoverItem))
                .click()
                .perform();
    }

    public void rightClick() {
        actions.contextClick(waitForVisible(rightClickArea)).perform();
    }
}
