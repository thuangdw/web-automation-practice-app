package com.example.pages;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class CookiesPage extends BasePage {

    private final String url = "http://localhost:8080/cookies.html";

    public CookiesPage(WebDriver driver) {
        super(driver);
    }

    public CookiesPage load() {
        driver.get(url);
        return this;
    }

    public void addCookie(String name, String value) {
        driver.manage().addCookie(new Cookie(name, value));
    }

    public Cookie getCookie(String name) {
        return driver.manage().getCookieNamed(name);
    }
}
