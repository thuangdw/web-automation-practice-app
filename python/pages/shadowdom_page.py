from selenium.webdriver.common.by import By
from .base_page import BasePage


class ShadowDomPage(BasePage):

    HOST = (By.ID, "shadow-host")
    SHADOW_TEXT = "#shadow-text"

    def read_shadow_text(self):
        host = self.wait_visible(self.HOST)
        shadow_root = host.shadow_root
        return shadow_root.find_element(By.CSS_SELECTOR, self.SHADOW_TEXT).text
