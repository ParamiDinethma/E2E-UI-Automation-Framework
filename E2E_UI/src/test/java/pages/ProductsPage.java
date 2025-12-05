package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {

    // --- LOCATORS ---
    private final By productsHeader = By.className("title"); // Should display "Products"
    private final By backpackAddToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By shoppingCartLink = By.className("shopping_cart_link");

    // --- CONSTRUCTOR ---
    public ProductsPage(WebDriver driver) {
        super(driver);
        // No need to navigate here, as this page is reached after a successful login.
    }

    // --- VALIDATION METHODS ---
    public boolean isProductsHeaderDisplayed() {
        // Use the explicit wait from BasePage to ensure the element is visible
        WebElement headerElement = driver.findElement(productsHeader);
        return headerElement.isDisplayed();
    }

    // --- ACTION METHODS ---
    public void addBackpackToCart() {
        // Use the inherited click method
        WebElement addButton = driver.findElement(backpackAddToCartButton);
        doClick(addButton);
    }

    // Action method to transition to the next page
    public CartPage navigateToCart() {
        WebElement cartIcon = driver.findElement(shoppingCartLink);
        doClick(cartIcon);
        return new CartPage(driver); // Assuming you'll create CartPage next
    }
}