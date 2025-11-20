package com.practiceapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage extends BasePage {

    private final By fileInput = By.cssSelector("#file-upload-input");
    private final By uploadButton = By.cssSelector("#upload-btn");
    private final By uploadedFileName = By.cssSelector("#uploaded-file-name");

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

    public String getUploadedFileName() {
        return getText(uploadedFileName);
    }
}
