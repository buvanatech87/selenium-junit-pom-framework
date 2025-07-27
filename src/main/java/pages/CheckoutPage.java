package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import actions.CheckoutActions;

public class CheckoutPage implements CheckoutActions {
    private WebDriver driver;

    private By firstNameInput = By.id("first-name");
    private By lastNameInput = By.id("last-name");
    private By postalCodeInput = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By confirmationText = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void startCheckout() {
        driver.findElement(By.id("checkout")).click();
    }

    @Override
    public void enterCheckoutInformation(String firstName, String lastName, String postalCode) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(postalCodeInput).sendKeys(postalCode);
        driver.findElement(continueButton).click();
    }

    @Override
    public void finishCheckout() {
        driver.findElement(finishButton).click();
    }

    @Override
    public boolean isCheckoutComplete() {
        return driver.findElement(confirmationText).isDisplayed();
    }
}
