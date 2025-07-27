package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import dev.failsafe.internal.util.Assert;
//import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import pages.LoginPage;
import utils.ExtentReportManager;

@SuppressWarnings("unused")
public class LoginTest extends BaseTest {
	
	private LoginPage loginPage;

    static ExtentReports extent;
    static ExtentTest test;
    
   
    @BeforeAll
    public static void startReport() {
        extent = ExtentReportManager.getInstance();
    }

    /*@BeforeEach
    public void setupTest(TestInfo info) {
        test = extent.createTest(info.getDisplayName());
    }
    
    @Test
    @DisplayName("Valid Login Test")
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        System.out.println("Test Run and completed");
    }
    
    
    @Test
    @DisplayName("Invalid Login Test")
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("tandard_user", "secret_sauce");

        String errorMsg = loginPage.getErrorMessage();
        String expectedMsg = "Epic sadface: Username and password do not match any user in this service";

        Assertions.assertEquals(expectedMsg, errorMsg);
        test.pass("Assertion passed: Error message matches");
    }

    @AfterEach
    public void tearDown(TestInfo info) {
        test.info("Finished test: " + info.getDisplayName());
    }*/
    
    
    @BeforeEach
    public void init() {
        super.setUp();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidLogin() {
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(loginPage.isOnProductsPage(), "User should be redirected to Products page");
    }

    @Test
    public void testInvalidUsername() {
        loginPage.login("invalid_user", "secret_sauce");
        assertEquals("Epic sadface: Username and password do not match any user in this service", loginPage.getErrorMessage());
    }

    @Test
    public void testInvalidPassword() {
        loginPage.login("standard_user", "wrongpass");
        assertTrue(loginPage.getErrorMessage().toLowerCase().contains("do not match"));
    }

    @Test
    public void testBlankFields() {
        loginPage.login("", "");
        assertEquals("Epic sadface: Username is required", loginPage.getErrorMessage());
    }

    @Test
    public void testLockedOutUser() {
        loginPage.login("locked_out_user", "secret_sauce");
        assertEquals("Epic sadface: Sorry, this user has been locked out.", loginPage.getErrorMessage());
    }

    @Test
    public void testCaseSensitivityInUsername() {
        loginPage.login("STANDARD_USER", "secret_sauce");
        assertTrue(loginPage.getErrorMessage().toLowerCase().contains("do not match"));
    }

    @Test
    public void testSQLInjectionLogin() {
        loginPage.login("' OR '1'='1", "anything");
        assertTrue(loginPage.getErrorMessage().toLowerCase().contains("do not match") || loginPage.getErrorMessage().length() > 0);
    }

    @AfterEach
    public void tearDownTest() {
        super.tearDown();
    }

    @AfterAll
    public static void flushReport() {
        extent.flush();
    }
    
}
