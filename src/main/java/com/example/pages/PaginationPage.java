package com.practiceapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginationPage extends BasePage {

    private final By nextBtn = By.id("next-page");
    private final By prevBtn = By.id("prev-page");
    private final By pageNumber = By.id("page-number");

    public PaginationPage(WebDriver driver) {
        super(driver);
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
