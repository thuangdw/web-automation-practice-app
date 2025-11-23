package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadPage extends BasePage {

    private final By fileInput = By.id("uploadFile");
    private final By uploadBtn = By.id("uploadBtn");
    private final String url = "http://localhost:8080/file-upload.html";

    public UploadPage(WebDriver driver) {
        super(driver);
    }

    public UploadPage load() {
        driver.get(url);
        return this;
    }

    public UploadPage uploadFile(String path) {
        driver.findElement(fileInput).sendKeys(path);
        click(uploadBtn);
        return this;
    }
}
