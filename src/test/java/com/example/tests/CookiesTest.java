package com.example.tests;

import com.example.pages.CookiesPage;
import com.example.utils.TestBase;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CookiesTest extends TestBase {

    @Test
    public void testCookies() {
        CookiesPage p = new CookiesPage(driver).load();
        p.addCookie("testCookie", "value123");
        Cookie c = p.getCookie("testCookie");
        Assert.assertNotNull(c);
        Assert.assertEquals(c.getValue(), "value123");
    }
}
