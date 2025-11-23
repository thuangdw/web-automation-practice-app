package com.practiceapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ModalPage extends BasePage {

    private final By openModalBtn = By.id("open-modal");
    private final By modal = By.id("modal");
    private final By closeModalBtn = By.id("close-modal");

    public ModalPage(WebDriver driver) {
        super(driver);
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
