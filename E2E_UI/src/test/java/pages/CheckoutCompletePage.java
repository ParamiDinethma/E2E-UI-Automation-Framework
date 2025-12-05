package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckoutCompletePage extends BasePage {

    // --- LOCATORS ---
    private final By completeHeader = By.className("complete-header"); // Should display "THANK YOU FOR YOUR ORDER"

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    // --- VALIDATION METHODS ---
    public boolean isOrderSuccessful() {
        WebElement headerElement = driver.findElement(completeHeader);
        return doGetText(headerElement).equals("THANK YOU FOR YOUR ORDER");
    }
}