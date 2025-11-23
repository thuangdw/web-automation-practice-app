package com.example.tests;

import com.example.pages.HomePage;
import com.example.utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptTest extends TestBase {

    @Test
    public void testPerformanceTimingAndJsClick() {
        // Use HomePage as a place to run JS
        HomePage h = new HomePage(driver).load();
        // JS example: get page load timing
        Long loadTime = (Long) ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("return performance.timing.loadEventEnd - performance.timing.navigationStart;");
        System.out.println("Load time: " + loadTime);
        Assert.assertNotNull(loadTime);
    }
}
