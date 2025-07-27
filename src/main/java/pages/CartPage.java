package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import actions.CartActions;

public class CartPage implements CartActions {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void addItemToCart(String itemName) {
        driver.findElement(By.xpath("//div[text()='" + itemName + "']/ancestor::div[@class='inventory_item']//button")).click();
    }

    @Override
    public void removeItemFromCart(String itemName) {
        driver.findElement(By.xpath("//div[text()='" + itemName + "']/ancestor::div[@class='cart_item']//button")).click();
    }

    @Override
    public int getItemCountInCart() {
        return driver.findElements(By.className("cart_item")).size();
    }

    @Override
    public boolean isItemInCart(String itemName) {
        return driver.getPageSource().contains(itemName);
    }

    public void goToCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }
}
