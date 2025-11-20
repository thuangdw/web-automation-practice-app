from selenium.webdriver.common.by import By
from .base_page import BasePage


class DragDropPage(BasePage):

    SOURCE = (By.ID, "drag-source")
    TARGET = (By.ID, "drop-target")

    def drag_and_drop(self):
        src = self.wait_visible(self.SOURCE)
        tgt = self.wait_visible(self.TARGET)
        self.actions.drag_and_drop(src, tgt).perform()
        return self
