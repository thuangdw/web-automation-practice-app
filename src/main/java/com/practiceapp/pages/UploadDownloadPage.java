package com.practiceapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadDownloadPage extends BasePage {

    // Locators
    private final By header = By.tagName("h2");

    private final By fileUploadInput = By.id("fileUpload");
    private final By uploadBtn = By.id("uploadBtn");
    private final By uploadedFileName = By.id("uploadedFileName");

    private final By downloadBtn = By.id("downloadBtn");

    // Constructor
    public UploadDownloadPage(WebDriver driver) {
        super(driver);
    }

    // Actions
    public String getHeader() {
        return getText(header);
    }

    public void uploadFile(String filePath) {
        driver.findElement(fileUploadInput).sendKeys(filePath);
        click(uploadBtn);
        waitForVisible(uploadedFileName);
    }

    public String getUploadedFileName() {
        return getText(uploadedFileName);
    }

    public void clickDownloadButton() {
        click(downloadBtn);
    }
}
