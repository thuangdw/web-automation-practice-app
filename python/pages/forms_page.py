from selenium.webdriver.common.by import By
from .base_page import BasePage


class FormsPage(BasePage):

    NAME = (By.ID, "name")
    EMAIL = (By.ID, "email")
    SUBMIT_BTN = (By.ID, "submit-btn")
    RESULT = (By.ID, "result")

    def enter_name(self, name):
        self.type(self.NAME, name)
        return self

    def enter_email(self, email):
        self.type(self.EMAIL, email)
        return self

    def submit(self):
        self.click(self.SUBMIT_BTN)
        return self

    def get_result(self):
        return self.get_text(self.RESULT)
