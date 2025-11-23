package com.example.tests;

import com.example.pages.WaitsPage;
import com.example.utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitsTest extends TestBase {

    @Test
    public void testExplicitWaits() {
        WaitsPage p = new WaitsPage(driver).load();
        String text = p.waitForDelayedText();
        Assert.assertTrue(text.toLowerCase().contains("loaded"));
    }
}
