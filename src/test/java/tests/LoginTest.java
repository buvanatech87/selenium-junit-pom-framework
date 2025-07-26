package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import dev.failsafe.internal.util.Assert;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
	

    static ExtentReports extent;
    static ExtentTest test;

    @BeforeAll
    public static void startReport() {
        extent = ExtentReportManager.getInstance();
    }

    @BeforeEach
    public void setupTest(TestInfo info) {
        test = extent.createTest(info.getDisplayName());
    }

    @Test
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
    }

    @AfterAll
    public static void flushReport() {
        extent.flush();
    }
    
}
