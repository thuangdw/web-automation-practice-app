[//]: # (current)
# Web Automation Practice App

This is a practice web application designed for learning and practicing Selenium (Java & Python) and Playwright automation. It includes pages for:

Login & Home

Forms & Dropdowns

Alerts & Prompts

IFrames

Shadow DOM

File Upload / Download

Dynamic content for advanced waits

## Docker Setup
1.Windows / Mac: Download and install from Docker Desktop

Linux: Install via package manager. Example for Ubuntu:

sudo apt update
sudo apt install docker.io
sudo systemctl enable --now docker
Verify installation:

bash
Copy code
docker --version


web-automation-practice-app — including:

✔ Docker instructions
✔ How to run via Maven or Gradle
✔ How to navigate the practice pages
✔ Sample Java + Python Selenium test code
✔ Explanation of folder structure



web-automation-practice-app

A fully local, Docker-based practice web application for learning Selenium, Playwright, and advanced web automation techniques.

This app includes pages for alerts, login, tables, dropdowns, dynamic content, file upload/download, iframes, shadow DOM, modal dialogs, multi windows, slow-loading elements, drag/drop, checkboxes, and more.


Mac
brew install --cask docker


Open Docker.app after installation.

Windows

Download Docker Desktop:
https://www.docker.com/products/docker-desktop/

Linux (Ubuntu example)
sudo apt update
sudo apt install docker.io
sudo systemctl enable --now docker


To verify Docker works:

docker --version

🚀 2. Build & Run the Web App with Docker
Build the Docker image

Run this inside the project root:

docker build -t web-automation-practice-app .

Start the container
docker run -d -p 8080:8080 --name web-app web-automation-practice-app

Open the app

Go to:

👉 http://localhost:8080

You will see the homepage with links to all automation practice pages.

Note: if the above steps failed to work for your environment, try something like the following:

if not working: you can install podman for Mac book with Apple chip:

brew install podman
podman machine init
podman machine start

podman pull docker.io/library/amazoncorretto:17-alpine

then update dockerfile with:

FROM docker.io/library/amazoncorretto:17-alpine

in terminal: 
podman pull docker.io/library/openjdk:17-jre-slim

docker build -t web-automation-practice-app .
or for Mac with applie chip:

podman build --platform=linux/amd64 -t web-automation-practice-app .

podman run -p 8080:8080 web-automation-practice-app


📁 3. Project Structure
web-automation-practice-app/
│
├── Dockerfile
├── README.md
├── pom.xml                     ← Maven build config
├── build.gradle                ← Gradle build config
├── settings.gradle
│
├── src/
│  ├── main/
│  │   ├── java/com/example/webapp/… (optional backend)
│  │   └── resources/webapp/
│  │        ├── index.html
│  │        ├── login.html
│  │        ├── alerts.html
│  │        ├── dynamic-content.html
│  │        ├── tables.html
│  │        ├── dropdowns.html
│  │        ├── upload.html
│  │        ├── download.html
│  │        ├── iframe.html
│  │        ├── shadow-dom.html
│  │        ├── windows.html
│  │        ├── modal.html
│  │        ├── slow-loading.html
│  │        └── drag-drop.html
│  │
│  └── test/java/com/example/
│        ├── BasicSeleniumTest.java
│        └── AdvancedSeleniumTest.java
│
├── python/
│   ├── basic_selenium_test.py
│   └── advanced_selenium_test.py
│
└── docs/
├── basicSeleniumSkills.md
└── advancedSeleniumSkills.md
⚙️ Java Tests Setup
1. Gradle

build.gradle includes dependencies for Selenium, TestNG, WebDriverManager:

dependencies {
testImplementation 'org.seleniumhq.selenium:selenium-java:4.14.0'
testImplementation 'io.github.bonigarcia:webdrivermanager:5.5.1'
testImplementation 'org.testng:testng:7.9.0'
}


Run tests:

./gradlew test

2. Maven

pom.xml dependencies:

<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.14.0</version>
    </dependency>
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.5.1</version>
    </dependency>
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.9.0</version>
    </dependency>
</dependencies>


Run tests:

mvn test

3. Sample Java Test Snippet
   WebDriver driver = new ChromeDriver();
   driver.get("http://localhost:8080/login");
   LoginPage login = new LoginPage(driver);
   HomePage home = login.enterEmail("admin@test.com")
   .enterPassword("secret123")
   .clickLogin();
   System.out.println(home.getWelcomeMessage());
   driver.quit();

🐍 Python Tests Setup
1. Install Dependencies
   python -m venv venv
   source venv/bin/activate       # Linux/Mac
   venv\Scripts\activate          # Windows

pip install selenium

2. Run Tests
   python -m unittest tests.basic_selenium_test
   python -m unittest tests.advanced_selenium_test

3. Sample Python Test Snippet
   from selenium import webdriver
   from pages.login_page import LoginPage

driver = webdriver.Chrome()
driver.get("http://localhost:8080/login")

home = LoginPage(driver)\
.enter_email("admin@test.com")\
.enter_password("secret123")\
.click_login()

print(home.get_welcome_message())
driver.quit()

📝 Documentation

docs/basicSeleniumSkills.md → Basic Selenium skills (Java + Python)

docs/advancedSeleniumSkills.md → Advanced Selenium skills (Java + Python)

✅ Project Structure
web-automation-practice-app/
│
├─ pages/                  # Python Page Objects
├─ tests/                  # Python test scripts
├─ src/main/java/...       # Java Page Objects & TestNG tests
├─ build.gradle            # Gradle build
├─ pom.xml                 # Maven build
├─ docs/                   # Markdown skills documentation
├─ Dockerfile
└─ README.md

🧪 4. Run Back-End Tests
Option A — Maven

From project root:

mvn clean test

Option B — Gradle
./gradlew test


Both will execute:

BasicSeleniumTest.java

AdvancedSeleniumTest.java

🧪 5. Sample Java Selenium Test

A simple test to verify the Docker app is running:

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;

public class SmokeTest {
@Test
public void testHomePageLoads() {
WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:8080");
        String title = driver.getTitle();

        System.out.println("Page Title: " + title);
        driver.quit();
    }
}

🐍 6. Sample Python Selenium Test
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager

driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()))

driver.get("http://localhost:8080")
print("Page title:", driver.title)

driver.quit()

🧭 7. Pages Included for Automation Practice
Page	Feature
/login.html	Login form (valid/invalid workflows)
/alerts.html	JS Alerts, confirmation, prompt
/dynamic-content.html	Dynamically changing text/IDs
/tables.html	Sortable + searchable table
/dropdowns.html	Single, multi-select dropdowns
/upload.html	File upload form
/download.html	File download link
/iframe.html	Single + nested iframes
/shadow-dom.html	Open shadow DOM interactions
/windows.html	Multiple browser windows/tabs
/modal.html	Modal dialogs
/slow-loading.html	Elements loaded after delay
/drag-drop.html	Drag and drop practice

✔ Each page is built specifically to support Selenium, Playwright, Cypress, Puppeteer, and WebDriverIO practice.

📘 8. Documentation

Two skill-level documents are included:

docs/basicSeleniumSkills.md

✔ Best for junior → mid-level
✔ Basic Java + Python syntax
✔ Navigating, locators, waits, forms, alerts, dropdowns, iframes, screenshots, etc.

docs/advancedSeleniumSkills.md

✔ Senior-level interview prep
✔ Advanced WebDriver setup
✔ Shadow DOM, dynamic elements, network logs
✔ DevTools API, retries, stale element handling
✔ File download automation
✔ Page Object Model (advanced templates)

🎓 9. Recommended Practice Workflow

Start Docker app

Open http://localhost:8080

Start from BasicSeleniumTest.java

Move to advanced tests

Explore POM patterns

Try same tests in Python

Extend tests for Playwright later

// updated:
# Web Automation Practice App (Advanced HTML)

This repo contains advanced practice HTML pages for Selenium & Playwright training.
Run the app locally (served on port 8080) and use the Playwright and Selenium projects to test it.

## Option A — Run with Docker (recommended)

### Build
```bash
docker build -t web-automation-practice-app .
Run
bash
Copy code
docker run --rm -p 8080:8080 --name web-practice web-automation-practice-app
Open: http://localhost:8080

Option B — Run locally with http-server (Node)
Install http-server if you don't have it:

bash
Copy code
npm install -g http-server
From repo root:

bash
Copy code
http-server -p 8080 -a 127.0.0.1 --cors
Open: http://localhost:8080

Helpful notes for test automation
The pages expose helper functions under window.__testHelpers for many test actions (e.g. toggling latency, fetching last download name, replacing DOM to create stale-element situations).

If running in Docker, make sure your automation runner (Playwright / Selenium) can access http://localhost:8080. If running tests on host machine while container is used, http://localhost:8080 works; if running tests in another container, you may need to use host networking or container names.

Playwright project
See the playwright-automation-practice repo (separate folder). Run:

bash
Copy code
cd ../playwright-automation-practice
npm install
npx playwright install
npx playwright test
Java Selenium project
See the selenium-automation-practice folder:

Maven: mvn test

Gradle: ./gradlew test

pgsql
Copy code

---

## 2) Playwright + TypeScript project

Create a folder `playwright-automation-practice/` with the structure below. I’ll include `package.json`, `playwright.config.ts`, `tsconfig.json`, POMs in `pages/` and tests in `tests/`.

### `package.json`
```json
{
  "name": "playwright-automation-practice",
  "version": "1.0.0",
  "private": true,
  "scripts": {
    "test": "playwright test",
    "test:headed": "playwright test --headed",
    "report": "playwright show-report"
  },
  "devDependencies": {
    "@playwright/test": "^1.45.0",
    "typescript": "^5.4.0"
  }
}