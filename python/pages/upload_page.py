from selenium.webdriver.common.by import By
from .base_page import BasePage


class UploadPage(BasePage):

    FILE_INPUT = (By.ID, "file-upload")
    UPLOAD_BTN = (By.ID, "upload-btn")
    RESULT = (By.ID, "upload-result")

    def upload_file(self, path):
        self.upload_file(self.FILE_INPUT, path)
        self.click(self.UPLOAD_BTN)
        return self

    def get_result(self):
        return self.get_text(self.RESULT)
