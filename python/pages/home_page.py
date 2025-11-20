from selenium.webdriver.common.by import By
from .base_page import BasePage


class HomePage(BasePage):
    WELCOME = (By.ID, "welcome")

    def get_welcome_message(self):
        return self.get_text(self.WELCOME)
