package com.practiceapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadDownloadPage extends BasePage {

    // Locators
    private final By header = By.tagName("h2");

    private final By fileUploadInput = By.id("uploadFile");
    private final By uploadBtn = By.id("uploadBtn");

    private final By downloadLink = By.id("downloadLink");

    // Constructor
    public UploadDownloadPage(WebDriver driver) {
        super(driver);
    }

    // Actions
    public String getHeader() {
        return getText(header);
    }

    public void uploadFile(String filePath) {
        find(fileUploadInput).sendKeys(filePath);
        click(uploadBtn);
    }

    public void clickDownloadLink() {
        click(downloadLink);
    }
}
