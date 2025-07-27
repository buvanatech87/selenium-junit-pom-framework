# selenium-junit-pom-framework
POM and Junit framework automation project


# 🔍 Selenium-JUnit-POM Framework with Jenkins & GitHub Actions (Windows)

This repository demonstrates a complete UI automation framework using **Selenium**, **JUnit 5**, **Maven**, and **Page Object Model (POM)**. It includes CI integration with both **Jenkins** and **GitHub Actions**.

---

## 📁 Project Structure

selenium-junit-pom/
├── pom.xml
├── Jenkinsfile
├── README.md
└── src
    ├── main
    │   └── java
    │       └── pages/
    │           ├── BasePage.java
    │           ├── LoginPage.java
    │           └── InventoryPage.java
    └── test
        ├── java
        │   ├── testBase/
        │   │   └── TestBase.java
        │   ├── testCases/
        │   │   ├── LoginTest.java
        │   │   ├── CartTest.java
        │   │   └── CheckoutTest.java
        │   └── testSuites/
        │       ├── SmokeTestSuite.java
        │       ├── RegressionTestSuite.java
        │       ├── E2ETestSuite.java
        │       └── AllTestsSuite.java
        └── resources/
            ├── config.properties
            └── testdata/
                └── testdata.xlsx



---

## 🔧 Technologies Used

- Java 21
- Maven
- Selenium WebDriver
- JUnit 5
- ChromeDriver (Headless)
- GitHub Actions (Windows)
- Jenkins
- ExtentReports

---

## ✅ Setup Instructions

### 1. Pre-Requisites

- Java 21 (JDK)
- Maven
- Chrome Browser (v138+)
- ChromeDriver matching Chrome version
- Git (configured globally)

---

### 2. Run Locally

```bash
mvn clean test



===================================================================================================

# Check Chrome version
chrome --version

# Download matching ChromeDriver
https://googlechromelabs.github.io/chrome-for-testing/

# Place chromedriver.exe in a known path or use WebDriverManager





