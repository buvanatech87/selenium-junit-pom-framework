package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.LoginActions;

public class LoginPage implements LoginActions  //extends BasePage 
{

    private WebDriver driver;
    private WebDriverWait wait;

    
    //locators
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("[data-test='error']");
    private By productsTitle = By.cssSelector(".title");

    //constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;  // Important!
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));   }

    
    //Actions
    public void login(String user, String pass) {
    	driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(password));       
                
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginButton).click();
    }
    
    public String getErrorMessage() {
    	try {
            return driver.findElement(errorMessage).getText();
        } catch (Exception e) {
            return "";
        }
    }
    
    public boolean isOnProductsPage() {
        try {
            return driver.findElement(productsTitle).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isAtLoginPage() {
        return driver.findElement(loginButton).isDisplayed();
    }


	@Override
	public boolean isLoginSuccessful() {
		// TODO Auto-generated method stub
		return false;
	}
}
