from selenium.webdriver.common.by import By
from .base_page import BasePage


class AlertsPage(BasePage):

    ALERT_BTN = (By.ID, "alert-btn")
    CONFIRM_BTN = (By.ID, "confirm-btn")
    PROMPT_BTN = (By.ID, "prompt-btn")

    def click_alert(self):
        self.click(self.ALERT_BTN)
        self.accept_alert()
        return self

    def click_confirm_accept(self):
        self.click(self.CONFIRM_BTN)
        self.accept_alert()
        return self

    def click_prompt(self, text):
        self.click(self.PROMPT_BTN)
        alert = self.driver.switch_to.alert
        alert.send_keys(text)
        alert.accept()
        return self
