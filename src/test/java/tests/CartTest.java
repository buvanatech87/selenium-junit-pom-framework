package tests;

import org.junit.jupiter.api.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;
import utils.ExtentReportManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class CartTest extends BaseTest {
	
	private LoginPage loginPage;

    static ExtentReports extent;
    static ExtentTest test;
    
   
    @BeforeAll
    public static void startReport() {
        extent = ExtentReportManager.getInstance();
    }

    @Test
    public void testAddItemToCart() {
        loginPage.login("standard_user", "secret_sauce");
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        cartPage.addItemToCart("Sauce Labs Backpack");
        cartPage.goToCart();

        assertTrue(cartPage.isItemInCart("Sauce Labs Backpack"));
        assertEquals(1, cartPage.getItemCountInCart());
    }

    @Test
    public void testRemoveItemFromCart() {
        loginPage.login("standard_user", "secret_sauce");
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        cartPage.addItemToCart("Sauce Labs Backpack");
        cartPage.goToCart();
        cartPage.removeItemFromCart("Sauce Labs Backpack");

        assertFalse(cartPage.isItemInCart("Sauce Labs Backpack"));
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
