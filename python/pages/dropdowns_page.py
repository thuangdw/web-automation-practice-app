from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select
from .base_page import BasePage


class DropdownsPage(BasePage):

    COUNTRY = (By.ID, "country")

    def select_country(self, country):
        select = Select(self.wait_visible(self.COUNTRY))
        select.select_by_visible_text(country)
        return self
