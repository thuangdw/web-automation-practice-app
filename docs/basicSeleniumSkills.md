# Basic Selenium Skills (Java + Python)

For Junior → Intermediate Automation Engineers

This guide covers the core Selenium skills required for most entry-level and mid-level QA automation interviews — using the training web app included in this project.

# 1. WebDriver Setup
Java
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.get("http://localhost:8080");

Python
from selenium import webdriver

driver = webdriver.Chrome()
driver.maximize_window()
driver.get("http://localhost:8080")

# 2. Locators (By strategies)
Supported in training pages:

id

name

cssSelector

xpath

className

Java
driver.findElement(By.id("email"));
driver.findElement(By.name("password"));
driver.findElement(By.cssSelector("#login-btn"));
driver.findElement(By.xpath("//input[@id='email']"));

Python
driver.find_element(By.ID, "email")
driver.find_element(By.NAME, "password")
driver.find_element(By.CSS_SELECTOR, "#login-btn")
driver.find_element(By.XPATH, "//input[@id='email']")

# 3. Clicking elements
Java
driver.findElement(By.id("login-btn")).click();

Python
driver.find_element(By.ID, "login-btn").click()

# 4. Typing into input fields

Used in login, forms, and iframe pages.

Java
driver.findElement(By.id("email")).sendKeys("admin@test.com");
driver.findElement(By.id("password")).sendKeys("secret123");

Python
driver.find_element(By.ID, "email").send_keys("admin@test.com")
driver.find_element(By.ID, "password").send_keys("secret123")

# 5. Getting text
Java
String msg = driver.findElement(By.id("welcome")).getText();

Python
msg = driver.find_element(By.ID, "welcome").text

# 6. Dropdowns (Select)

Using dropdowns.html

Java
Select country = new Select(driver.findElement(By.id("country")));
country.selectByVisibleText("Canada");

Python
from selenium.webdriver.support.ui import Select

select = Select(driver.find_element(By.ID, "country"))
select.select_by_visible_text("Canada")

# 7. Alerts (JavaScript Alerts)

For alert.html
Includes:

Alert

Confirm

Prompt

Java
driver.findElement(By.id("alert-btn")).click();
driver.switchTo().alert().accept();

Python
driver.find_element(By.ID, "alert-btn").click()
driver.switch_to.alert.accept()

# 8. Iframes

For iframe.html

Java
driver.switchTo().frame("frame1");
String text = driver.findElement(By.id("frame-text")).getText();
driver.switchTo().defaultContent();

Python
driver.switch_to.frame("frame1")
text = driver.find_element(By.ID, "frame-text").text
driver.switch_to.default_content()

# 9. Shadow DOM

For shadow-dom.html

Java
WebElement host = driver.findElement(By.id("shadow-host"));
SearchContext shadow = host.getShadowRoot();
String txt = shadow.findElement(By.cssSelector("#shadow-text")).getText();

Python
host = driver.find_element(By.ID, "shadow-host")
shadow = host.shadow_root
txt = shadow.find_element(By.CSS_SELECTOR, "#shadow-text").text

# 10. New Windows / Tabs

For windows.html

Java
String main = driver.getWindowHandle();
driver.findElement(By.id("open-window-btn")).click();

for (String handle : driver.getWindowHandles()) {
if (!handle.equals(main)) {
driver.switchTo().window(handle);
}
}

Python
main = driver.current_window_handle
driver.find_element(By.ID, "open-window-btn").click()

for h in driver.window_handles:
if h != main:
driver.switch_to.window(h)

# 11. Drag and Drop

For dragdrop.html

Java
WebElement src = driver.findElement(By.id("drag-source"));
WebElement tgt = driver.findElement(By.id("drop-target"));
new Actions(driver).dragAndDrop(src, tgt).perform();

Python
src = driver.find_element(By.ID, "drag-source")
tgt = driver.find_element(By.ID, "drop-target")
ActionChains(driver).drag_and_drop(src, tgt).perform()

# 12. File Upload

For upload.html

Java
driver.findElement(By.id("file-upload"))
.sendKeys("/path/to/file.txt");
driver.findElement(By.id("upload-btn")).click();

Python
driver.find_element(By.ID, "file-upload").send_keys("/path/to/file.txt")
driver.find_element(By.ID, "upload-btn").click()

# 13. File Download

For download.html

(No direct verification — clicking triggers browser save dialog.)

Java
driver.findElement(By.id("download-btn")).click();

Python
driver.find_element(By.ID, "download-btn").click()

# 14. Basic Explicit Waits

Used everywhere.

Java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

Python
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

wait = WebDriverWait(driver, 10)
wait.until(EC.visibility_of_element_located((By.ID, "email")))

# 15. Quit Browser
Java
driver.quit();

Python
driver.quit()
