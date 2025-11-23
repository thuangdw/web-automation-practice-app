package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TablesPage extends BasePage {

    private final By rows = By.cssSelector("#data-table tbody tr");
    private final By url = By.linkText("tables.html"); // fallback

    private final String pageUrl = "http://localhost:8080/tables.html";

    public TablesPage(WebDriver driver) {
        super(driver);
    }

    public TablesPage load() {
        driver.get(pageUrl);
        return this;
    }

    public int getRowCount() {
        List<WebElement> r = driver.findElements(rows);
        return r.size();
    }

    public String getCell(int rowIndex, int colIndex) {
        return driver.findElements(rows)
                .get(rowIndex)
                .findElements(By.tagName("td"))
                .get(colIndex)
                .getText();
    }
}
