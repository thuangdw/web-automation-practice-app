package com.example.pages;

import org.openqa.selenium.*;
import java.util.List;

public class TablesPage extends SeleniumBasePage {

    private final By tableRows = By.cssSelector("#data-table tbody tr");
    private final By sortButton = By.id("sort");

    public TablesPage(WebDriver driver) {
        super(driver);
        navigateTo("http://localhost:8080/tables.html");
    }

    public void sortTable() {
        click(sortButton);
    }

    public int getRowCount() {
        return driver.findElements(tableRows).size();
    }

    public String getCellText(int row, int column) {
        return driver.findElements(tableRows)
                .get(row)
                .findElements(By.tagName("td"))
                .get(column)
                .getText();
    }
}
