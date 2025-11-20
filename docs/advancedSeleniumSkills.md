
---

# 📘 **docs/advancedSeleniumSkills.md (FULL VERSION)**

```md
# Advanced Selenium Skills — Java & Python
This document covers **senior-level automation engineer** skills with Selenium.

---

# 1. Advanced Chrome Options

## Java
```java
ChromeOptions options = new ChromeOptions();
options.addArguments("--disable-notifications");
options.addArguments("--headless=new");
WebDriver driver = new ChromeDriver(options);
Python
python
Copy code
from selenium.webdriver.chrome.options import Options

opts = Options()
opts.add_argument("--disable-notifications")
opts.add_argument("--headless=new")
driver = webdriver.Chrome(options=opts)
2. Custom Explicit Waits
Java
java
Copy code
wait.until(driver -> 
    driver.findElement(By.id("progress")).getText().equals("100%")
);
Python
python
Copy code
wait.until(lambda d: d.find_element(By.ID, "progress").text == "100%")
3. Shadow DOM
Java
java
Copy code
JavascriptExecutor js = (JavascriptExecutor) driver;
WebElement host = driver.findElement(By.id("shadow-host"));
WebElement root = (WebElement) js.executeScript("return arguments[0].shadowRoot", host);
WebElement el = root.findElement(By.cssSelector(".shadow-item"));
Python
python
Copy code
host = driver.find_element(By.ID, "shadow-host")
root = driver.execute_script("return arguments[0].shadowRoot", host)
el = root.find_element(By.CSS_SELECTOR, ".shadow-item")
4. Complex XPath & CSS
Java
java
Copy code
driver.findElement(By.xpath("//label[text()='Email']/following-sibling::input"));
Python
python
Copy code
driver.find_element(By.XPATH, "//label[text()='Email']/following-sibling::input")
5. JavaScript Actions
Java
java
Copy code
js.executeScript("arguments[0].click();", button);
Python
python
Copy code
driver.execute_script("arguments[0].click()", button)
6. Multi Window Navigation
Java
java
Copy code
String main = driver.getWindowHandle();
for (String win : driver.getWindowHandles()) {
    if (!win.equals(main)) driver.switchTo().window(win);
}
Python
python
Copy code
main = driver.current_window_handle
for win in driver.window_handles:
    if win != main:
        driver.switch_to.window(win)
7. Stale Element Handling
Java
java
Copy code
public WebElement retryFind(By locator) {
    for (int i = 0; i < 3; i++) {
        try {
            return driver.findElement(locator);
        } catch (StaleElementReferenceException e) {}
    }
    throw new RuntimeException("Still stale");
}
Python
python
Copy code
def retry_find(driver, locator):
    for _ in range(3):
        try:
            return driver.find_element(*locator)
        except StaleElementReferenceException:
            pass
    raise Exception("Still stale")
8. Retry Logic (TestNG)
Java
java
Copy code
public class RetryAnalyzer implements IRetryAnalyzer {
    int count = 0;
    public boolean retry(ITestResult result) {
        return count++ < 2;
    }
}
9. Browser Logs
Java
java
Copy code
driver.manage().logs().get("browser").forEach(System.out::println);
Python
python
Copy code
for entry in driver.get_log("browser"):
    print(entry)
10. Screenshots
Java
java
Copy code
File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
Files.copy(scr.toPath(), Paths.get("shot.png"));
Python
python
Copy code
driver.save_screenshot("shot.png")