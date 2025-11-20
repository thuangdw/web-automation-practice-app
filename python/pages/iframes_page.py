from selenium.webdriver.common.by import By
from .base_page import BasePage


class IframesPage(BasePage):

    FRAME = (By.ID, "frame1")
    TEXT = (By.ID, "frame-text")

    def read_frame_text(self):
        self.switch_to_frame(self.FRAME)
        text = self.get_text(self.TEXT)
        self.switch_to_default()
        return text
