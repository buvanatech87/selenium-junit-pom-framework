package tests;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import factory.DriverFactory;


@SuppressWarnings("unused")
public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = DriverFactory.initializeDriver();
        driver.get("https://www.saucedemo.com/");
        System.out.println("✅ WebDriver initialized and navigated to SauceDemo");
    }

    @AfterEach
    public void tearDown() {
        DriverFactory.quitDriver();
        System.out.println("🧹 WebDriver closed");
    }
}

/*
public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        //WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // Headless mode for Jenkins
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        //driver = new ChromeDriver();
        driver = DriverFactory.initializeDriver();
        System.out.println("Driver initialized");
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}*/
