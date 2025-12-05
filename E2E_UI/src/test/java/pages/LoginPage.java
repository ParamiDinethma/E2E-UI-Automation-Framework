package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    // Locators for the Sauce Labs Demo Site
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessageContainer = By.cssSelector(".error-message-container");

    private final String url = "https://www.saucedemo.com/";

    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get(url); // Navigate to the login page upon object creation
    }

    // Action method to perform the login steps
    public void performLogin(String username, String password) {
        // We use the driver.findElement()... here as we don't have WebElement fields
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    // Validation method for negative tests
    public String getErrorMessage() {
        // Use the inherited doGetText method to wait for and retrieve the error message
        WebElement errorElement = driver.findElement(errorMessageContainer);
        return doGetText(errorElement);
    }
    // Action method to perform the login steps and return the next page object
    public ProductsPage loginSuccess(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();

        // Return the instance of the next page object
        return new ProductsPage(driver);
    }
}
