from selenium.webdriver.common.by import By
from .base_page import BasePage
from .home_page import HomePage


class LoginPage(BasePage):

    EMAIL = (By.ID, "email")
    PASSWORD = (By.ID, "password")
    LOGIN_BTN = (By.ID, "login-btn")

    def enter_email(self, email):
        self.type(self.EMAIL, email)
        return self

    def enter_password(self, password):
        self.type(self.PASSWORD, password)
        return self

    def click_login(self):
        self.click(self.LOGIN_BTN)
        return HomePage(self.driver)
