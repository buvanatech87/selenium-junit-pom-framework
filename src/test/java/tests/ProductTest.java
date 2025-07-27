package tests;

import org.junit.jupiter.api.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.LoginPage;
import pages.ProductPage;
import utils.ExtentReportManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class ProductTest extends BaseTest {
	
	private LoginPage loginPage;

    static ExtentReports extent;
    static ExtentTest test;
    
   
    @BeforeAll
    public static void startReport() {
        extent = ExtentReportManager.getInstance();
    }

    @Test
    public void testSortProductsByPriceLowToHigh() {
    	loginPage.login("standard_user", "secret_sauce");
        ProductPage productPage = new ProductPage(driver);
        assertTrue(productPage.isAtProductPage());
        productPage.sortProductsBy("Price (low to high)");
        // Add assertion to verify sort works if necessary
    }

    @Test
    public void testProductDisplay() {
        loginPage.login("standard_user", "secret_sauce");
        ProductPage productPage = new ProductPage(driver);
        assertTrue(productPage.isProductDisplayed("Sauce Labs Backpack"));
    }

    @Test
    public void testOpenProductDetails() {
        loginPage.login("standard_user", "secret_sauce");
        ProductPage productPage = new ProductPage(driver);
        productPage.openProductDetails("Sauce Labs Backpack");
        assertTrue(driver.getCurrentUrl().contains("inventory-item"));
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
