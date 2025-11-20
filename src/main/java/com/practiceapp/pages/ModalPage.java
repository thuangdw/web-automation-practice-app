package com.example.pages;

import org.openqa.selenium.*;

public class ModalPage extends SeleniumBasePage {

    private final By openModalBtn = By.id("open-modal");
    private final By modal = By.id("modal");
    private final By closeModalBtn = By.id("close-modal");

    public ModalPage(WebDriver driver) {
        super(driver);
        navigateTo("http://localhost:8080/modal.html");
    }

    public void openModal() {
        click(openModalBtn);
    }

    public void closeModal() {
        click(closeModalBtn);
    }

    public boolean isModalVisible() {
        return isDisplayed(modal);
    }
}
