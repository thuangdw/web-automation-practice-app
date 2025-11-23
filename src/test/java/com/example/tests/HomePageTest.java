package com.example.tests;

import com.example.pages.HomePage;
import com.example.pages.LoginPage;
import com.example.utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    @Test
    public void testHomeInteractions() {
        LoginPage login = new LoginPage(driver).load();
        HomePage home = login.enterEmail("admin@test.com")
                             .enterPassword("secret123")
                             .clickLogin();

        Assert.assertTrue(home.getWelcomeMessage().contains("Welcome"));

        home.enterStatus("Automation rocks!")
            .submitStatus();

        // optionally assert status result if available
        // Assert.assertTrue(home.getStatusResult().contains("Automation rocks"));
    }
}
