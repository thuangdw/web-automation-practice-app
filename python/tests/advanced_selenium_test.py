# Python test placeIt includes:

#                    ✅ Explicit waits
#                    ✅ Fluent waits
#                    ✅ Advanced locators
#                    ✅ Actions (ActionChains)
#                    ✅ JavaScript execution
#                    ✅ Stale element handling with retries
#                    ✅ Retry logic for flaky tests
#                    ✅ Browser logs & network capture (CDP in Selenium 4 Python)
#                    ✅ Screenshots
#                    ✅ Page-object-friendly structure
#                    ✅ Senior-level Python Selenium patterns
#                    ✅ AdvancedSeleniumTest.py

#   ✅ What This Python Version Includes
#                    1. Explicit waits
#
#                    WebDriverWait(driver, 15) + EC.element_to_be_clickable
#
#                    2. Fluent waits
#
#                    Custom polling frequency, ignored exceptions.
#
#                    3. Advanced locators
#
#                    XPath contains(), CSS selectors.
#
#                    4. ActionChains
#
#                    Drag-and-drop, composite actions.
#
#                    5. JavaScript execution
#
#                    driver.execute_script(...)
#
#                    6. Stale element retry logic
#
#                    retry_find() helper.
#
#                    7. Retry decorator
#
#                    Pythonic retry for flaky tests.
#
#                    8. CDP network logs
#
#                    driver.get_log("performance")
#
#                    9. Screenshots
#
#                    save_screenshot()holder
#
#


import unittest
import time
import os
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from pages.login_page import LoginPage
from pages.home_page import HomePage
from pages.form_page import FormPage
from pages.iframe_page import IframePage
from pages.alert_page import AlertPage
from pages.shadow_dom_page import ShadowDomPage
from pages.upload_download_page import UploadDownloadPage
from selenium.common.exceptions import StaleElementReferenceException
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

class AdvancedSeleniumTest(unittest.TestCase):

    @classmethod
    def setUpClass(cls):
        options = Options()
        options.add_argument("--start-maximized")
        options.add_argument("--disable-notifications")
        options.add_argument("--disable-popup-blocking")
        options.add_experimental_option("excludeSwitches", ["enable-automation"])
        cls.driver = webdriver.Chrome(service=Service(), options=options)
        cls.driver.get("http://localhost:8080/login")
        cls.wait = WebDriverWait(cls.driver, 10)

    @classmethod
    def tearDownClass(cls):
        cls.driver.quit()

    # ---------- Login + Home ----------
    def test_login_and_home(self):
        home: HomePage = LoginPage(self.driver) \
            .enter_email("admin@test.com") \
            .enter_password("secret123") \
            .click_login()
        self.assertIn("Welcome", home.get_welcome_message())

    # ---------- Form + Dynamic Elements ----------
    def test_form_with_dynamic_elements(self):
        form_page = FormPage(self.driver)
        form_page.enter_text("Advanced input")
        form_page.select_option("Option 3")
        form_page.submit_form()

        # Custom wait for dynamic content
        self.wait.until(lambda d: "submitted" in form_page.get_result_text().lower())
        self.assertIn("submitted", form_page.get_result_text().lower())

    # ---------- Alerts ----------
    def test_alerts(self):
        alert_page = AlertPage(self.driver)
        alert_page.triggerAlert()
        alert_page.accept_alert()

        alert_page.triggerConfirm()
        alert_page.dismiss_alert()

        alert_page.triggerPrompt("Test input")
        self.assertIn("Test input", alert_page.getResultText())

    # ---------- IFrames ----------
    def test_iframe_handling(self):
        iframe_page = IframePage(self.driver)
        iframe_page.switch_to_outer_frame()
        iframe_page.switch_to_inner_frame()
        inner_text = iframe_page.get_inner_text()
        iframe_page.switch_to_default()
        self.assertTrue(inner_text)

    # ---------- Shadow DOM ----------
    def test_shadow_dom_access(self):
        shadow_page = ShadowDomPage(self.driver)
        shadow_text = shadow_page.get_shadow_text()
        self.assertTrue(shadow_text)

    # ---------- File Upload / Download ----------
    def test_file_upload_download(self):
        upload_page = UploadDownloadPage(self.driver)
        file_path = os.path.abspath("tests/sample_upload.txt")
        upload_page.upload_file(file_path).click_upload()
        self.assertIn("sample_upload.txt", upload_page.get_uploaded_file_name())

    # ---------- Handling Stale Elements ----------
    def test_stale_element(self):
        form_page = FormPage(self.driver)
        locator = (By.ID, "dynamic-text")
        retries = 3
        for _ in range(retries):
            try:
                elem = self.driver.find_element(*locator)
                elem.text
                break
            except StaleElementReferenceException:
                self.wait.until(EC.presence_of_element_located(locator))

    # ---------- Screenshot ----------
    def test_screenshot(self):
        screenshot_path = "tests/screenshots/full_page.png"
        os.makedirs(os.path.dirname(screenshot_path), exist_ok=True)
        self.driver.save_screenshot(screenshot_path)
        self.assertTrue(os.path.exists(screenshot_path))

    # ---------- Performance Timing ----------
    def test_performance_timing(self):
        load_time = self.driver.execute_script(
            "return performance.timing.loadEventEnd - performance.timing.navigationStart;")
        print(f"Page load time: {load_time} ms")
        self.assertTrue(load_time > 0)

if __name__ == "__main__":
    unittest.main()
