package com.practiceapp.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PerformancePage extends BasePage {

    public PerformancePage(WebDriver driver) {
        super(driver);
    }

    public long getPageLoadTime() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (Long) js.executeScript(
                "return performance.timing.loadEventEnd - performance.timing.navigationStart;"
        );
    }
}
