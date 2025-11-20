from selenium.webdriver.common.by import By
from .base_page import BasePage


class WindowsPage(BasePage):

    OPEN_BTN = (By.ID, "open-window-btn")

    def switch_to_new_window(self):
        original = self.driver.current_window_handle

        self.click(self.OPEN_BTN)

        for handle in self.driver.window_handles:
            if handle != original:
                self.driver.switch_to.window(handle)
                return self.driver.title

        return None
