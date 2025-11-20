from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.action_chains import ActionChains


class BasePage:
    def __init__(self, driver):
        self.driver = driver
        self.wait = WebDriverWait(driver, 10)
        self.actions = ActionChains(driver)

    def wait_visible(self, locator):
        return self.wait.until(EC.visibility_of_element_located(locator))

    def wait_clickable(self, locator):
        return self.wait.until(EC.element_to_be_clickable(locator))

    def click(self, locator):
        self.wait_clickable(locator).click()

    def type(self, locator, text):
        elem = self.wait_visible(locator)
        elem.clear()
        elem.send_keys(text)

    def get_text(self, locator):
        return self.wait_visible(locator).text

    def switch_to_frame(self, locator):
        frame = self.wait_visible(locator)
        self.driver.switch_to.frame(frame)

    def switch_to_default(self):
        self.driver.switch_to.default_content()

    def accept_alert(self):
        self.wait.until(EC.alert_is_present()).accept()

    def dismiss_alert(self):
        self.wait.until(EC.alert_is_present()).dismiss()

    def upload_file(self, locator, file_path):
        self.driver.find_element(*locator).send_keys(file_path)
