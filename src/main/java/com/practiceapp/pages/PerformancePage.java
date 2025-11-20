package com.example.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PerformancePage extends SeleniumBasePage {

    public PerformancePage(WebDriver driver) {
        super(driver);
        navigateTo("http://localhost:8080/performance.html");
    }

    public long getPageLoadTime() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (Long) js.executeScript(
                "return performance.timing.loadEventEnd - performance.timing.navigationStart;"
        );
    }
}
