package tests;

import org.junit.jupiter.api.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;
import utils.ExtentReportManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class CheckoutTest extends BaseTest {
	
	private LoginPage loginPage;

    static ExtentReports extent;
    static ExtentTest test;
    
   
    @BeforeAll
    public static void startReport() {
        extent = ExtentReportManager.getInstance();
    }

    @Test
    public void testCompleteCheckout() {
        loginPage.login("standard_user", "secret_sauce");

        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        cartPage.addItemToCart("Sauce Labs Backpack");
        cartPage.goToCart();

        checkoutPage.startCheckout();
        checkoutPage.enterCheckoutInformation("John", "Doe", "12345");
        checkoutPage.finishCheckout();

        assertTrue(checkoutPage.isCheckoutComplete());
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