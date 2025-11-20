package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadPage extends SeleniumBasePage {

    private final By fileInput = By.id("file-upload");
    private final By uploadButton = By.id("upload-btn");
    private final By result = By.id("upload-result");

    public UploadPage(WebDriver driver) {
        super(driver);
    }

    public UploadPage uploadFile(String filePath) {
        uploadFile(fileInput, filePath);
        click(uploadButton);
        return this;
    }

    public String getResult() {
        return getText(result);
    }
}
