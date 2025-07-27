package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import actions.ProductActions;


public class ProductPage implements ProductActions {
    private WebDriver driver;

    private By productTitle = By.className("title");
    private By productSort = By.className("product_sort_container");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void sortProductsBy(String sortOption) {
        driver.findElement(productSort).sendKeys(sortOption);
    }

    @Override
    public boolean isProductDisplayed(String productName) {
        return driver.getPageSource().contains(productName);
    }

    @Override
    public void openProductDetails(String productName) {
        driver.findElement(By.xpath("//div[text()='" + productName + "']")).click();
    }

    public boolean isAtProductPage() {
        return driver.findElement(productTitle).getText().equals("Products");
    }
}