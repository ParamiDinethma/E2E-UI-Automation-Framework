package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    // --- LOCATORS ---
    // Locator for the item that was added (Sauce Labs Backpack)
    private final By backpackItem = By.id("item_4_title_link");
    // Locator for the Checkout button
    private final By checkoutButton = By.id("checkout");

    // --- CONSTRUCTOR ---
    public CartPage(WebDriver driver) {
        super(driver);
    }

    // --- VALIDATION METHODS ---
    public boolean isBackpackItemDisplayed() {
        // Checks if the Backpack item is present in the cart list
        WebElement itemElement = driver.findElement(backpackItem);
        return itemElement.isDisplayed();
    }

    public String getBackpackItemName() {
        // Gets the name of the item to confirm correctness
        WebElement itemElement = driver.findElement(backpackItem);
        return doGetText(itemElement);
    }

    // --- ACTION METHODS ---
    public CheckoutPage clickCheckout() {
        // Action to proceed to the next step
        WebElement checkoutBtn = driver.findElement(checkoutButton);
        doClick(checkoutBtn);
        // Assuming you will create a CheckoutPage next
        return new CheckoutPage(driver);
    }
}