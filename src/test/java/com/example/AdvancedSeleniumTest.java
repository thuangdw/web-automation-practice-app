// Java test placeholder

/**
 * Below is a clean, production-style Java Selenium test class that demonstrates:
 *
 * ✅ Explicit waits
 * ✅ Fluent waits
 * ✅ Advanced locators
 * ✅ Complex user interactions (Actions)
 * ✅ JavaScript execution
 * ✅ StaleElementReferenceException handling
 * ✅ Retry logic (simple custom retry analyzer)
 * ✅ Browser logs + network capture (Chrome DevTools Protocol)
 * ✅ Screenshots
 * ✅ Page Object usage patterns
 * ✅ Recommended structure for a senior engineer test suite
 * ✅ What This File Covers (Aligned With advancedSeleniumSkills.md)
 * 1. Explicit Waits
 *
 * WebDriverWait + ExpectedConditions
 *
 * 2. Fluent Waits
 *
 * Custom polling & timeout.
 *
 * 3. Advanced Locators
 *
 * CSS advanced selectors, XPath functions like contains().
 *
 * 4. Actions API
 *
 * Drag-and-drop, hover, composite actions.
 *
 * 5. JavaScript Executor
 *
 * DOM manipulation + fetch trigger.
 *
 * 6. Stale Element Strategies
 *
 * Custom retry logic.
 *
 * 7. Retry Analyzer
 *
 * TestNG IRetryAnalyzer implementation.
 *
 * 8. Browser Logs & Network Capture
 *
 * CDP (Chrome DevTools Protocol) event listener.
 *
 * 9. Screenshots
 *
 * TakesScreenshot.
 */

package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v128.network.Network;
import org.openqa.selenium.devtools.v128.network.model.Request;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Optional;

public class AdvancedSeleniumTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private DevTools devTools;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // ---------------------
        // Enable DevTools Logging
        // ---------------------
        devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
    }

    @Test(retryAnalyzer = RetryOnFailure.class)
    public void advancedInteractionsTest() throws InterruptedException {
        driver.get("https://example.com");

        // Explicit wait example
        WebElement dynamicBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dynamicBtn")));
        dynamicBtn.click();

        // Fluent wait example
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        WebElement fluentElement = fluentWait.until(d ->
                d.findElement(By.xpath("//div[@id='result']"))
        );
        Assert.assertTrue(fluentElement.isDisplayed());

        // Advanced locator example
        WebElement emailInput = driver.findElement(By.xpath("//input[contains(@placeholder,'email')]"));
        emailInput.sendKeys("test@example.com");

        // Action chains
        Actions actions = new Actions(driver);
        WebElement drag = driver.findElement(By.id("drag"));
        WebElement drop = driver.findElement(By.id("drop"));
        actions.dragAndDrop(drag, drop).perform();

        // JavaScript execution
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.backgroundColor='lightyellow'");

        // Stale element handling
        WebElement staleTarget = driver.findElement(By.id("staleElement"));
        staleTarget = retryFind(staleTarget);

        // Network logging example
        devTools.addListener(Network.requestWillBeSent(),
                request -> System.out.println("Network Request: " + request.getRequest().getUrl()));

        // Trigger a network call
        js.executeScript("fetch('/api/test-endpoint')");

        // Screenshot
        takeScreenshot("advancedTest.png");
    }

    // ---------------------------------------
    // Helper: retry logic for stale elements
    // ---------------------------------------
    private WebElement retryFind(WebElement element) {
        for (int i = 0; i < 3; i++) {
            try {
                element.click();
                return element;
            } catch (StaleElementReferenceException e) {
                System.out.println("Retry due to stale");
                element = driver.findElement(By.id("staleElement"));
            }
        }
        throw new RuntimeException("Still stale after retries");
    }

    // ---------------------------------------
    // Helper: Screenshot
    // ---------------------------------------
    private void takeScreenshot(String name) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(src.toPath(), new File("./screenshots/" + name).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ---------------------------------------
    // TestNG Retry Logic
    // ---------------------------------------
    public static class RetryOnFailure implements IRetryAnalyzer {
        private int retryCount = 0;
        private static final int maxRetry = 2;

        @Override
        public boolean retry(ITestResult result) {
            if (retryCount < maxRetry) {
                retryCount++;
                return true;
            }
            return false;
        }
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
