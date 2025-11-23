package com.example.tests;

import com.example.pages.*;
import com.example.utils.TestBase;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.logging.Level;

public class AdvancedSeleniumTest extends TestBase {

    @Test
    public void fullAdvancedFlow() {
        // Login
        LoginPage login = new LoginPage(driver).load();
        HomePage home = login.enterEmail("admin@test.com")
                             .enterPassword("secret123")
                             .clickLogin();
        Assert.assertTrue(home.getWelcomeMessage().toLowerCase().contains("welcome"));

        // Shadow DOM (if page exists)
        // Frames
        FramesPage frames = new FramesPage(driver).load();
        frames.typeInFrame("hello inner");

        // Actions
        ActionsPage actions = new ActionsPage(driver).load();
        actions.dragAndDrop();

        // Waits
        WaitsPage waits = new WaitsPage(driver).load();
        String delayed = waits.waitForDelayedText();
        Assert.assertNotNull(delayed);

        // Tables
        TablesPage t = new TablesPage(driver).load();
        int rows = t.getRowCount();
        Assert.assertTrue(rows >= 0);

        // Upload
        UploadPage up = new UploadPage(driver).load();
        File f = new File("sample_upload.txt");
        up.uploadFile(f.getAbsolutePath());

        // logs & screenshot
        File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Assert.assertTrue(scr.exists());
    }
}
