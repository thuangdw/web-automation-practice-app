package com.example.tests;

import com.example.pages.LoginPage;
import com.example.pages.HomePage;
import com.example.utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test(retryAnalyzer = com.example.utils.RetryAnalyzer.class)
    public void testLoginSuccess() {
        LoginPage login = new LoginPage(driver).load();
        HomePage home = login.enterEmail("admin@test.com")
                             .enterPassword("secret123")
                             .clickLogin();
        String welcome = home.getWelcomeMessage();
        Assert.assertTrue(welcome.toLowerCase().contains("welcome"));
    }
}
