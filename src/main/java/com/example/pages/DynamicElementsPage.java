package com.practiceapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicElementsPage extends BasePage {

    private final By dynamicElement1 = By.id("dynamic-1");
    private final By dynamicElement2 = By.id("dynamic-2");

    public DynamicElementsPage(WebDriver driver) {
        super(driver);
    }

    public String getDynamicText1() {
        return getText(dynamicElement1);
    }

    public String getDynamicText2() {
        return getText(dynamicElement2);
    }
}
