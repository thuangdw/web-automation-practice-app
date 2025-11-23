package com.practiceapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage extends BasePage {

    private final By fileInput = By.id("uploadFile");
    private final By uploadButton = By.id("uploadBtn");

    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    public FileUploadPage uploadFile(String absolutePath) {
        find(fileInput).sendKeys(absolutePath);
        return this;
    }

    public FileUploadPage clickUpload() {
        click(uploadButton);
        return this;
    }
}
