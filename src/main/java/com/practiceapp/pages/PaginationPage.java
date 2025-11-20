package com.example.pages;

import org.openqa.selenium.*;

public class PaginationPage extends SeleniumBasePage {

    private final By nextBtn = By.id("next-page");
    private final By prevBtn = By.id("prev-page");
    private final By pageNumber = By.id("page-number");

    public PaginationPage(WebDriver driver) {
        super(driver);
        navigateTo("http://localhost:8080/pagination.html");
    }

    public void nextPage() {
        click(nextBtn);
    }

    public void prevPage() {
        click(prevBtn);
    }

    public String getPageNumber() {
        return getText(pageNumber);
    }
}
