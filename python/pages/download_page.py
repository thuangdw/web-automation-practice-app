from selenium.webdriver.common.by import By
from .base_page import BasePage


class DownloadPage(BasePage):

    DOWNLOAD_BTN = (By.ID, "download-btn")

    def click_download(self):
        self.click(self.DOWNLOAD_BTN)
        return self
