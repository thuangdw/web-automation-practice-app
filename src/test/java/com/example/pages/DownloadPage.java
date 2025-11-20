package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DownloadPage extends SeleniumBasePage {

    private final By downloadBtn = By.id("download-btn");

    public DownloadPage(WebDriver driver) {
        super(driver);
    }

    public DownloadPage clickDownload() {
        click(downloadBtn);
        return this;
    }
}
