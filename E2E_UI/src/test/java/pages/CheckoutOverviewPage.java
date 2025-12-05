package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage extends BasePage {

    // --- LOCATORS ---
    private final By overviewTitle = By.className("title"); // Should display "Checkout: Overview"
    private final By finishButton = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    // --- VALIDATION METHODS ---
    // Check if the title element exists AND its text is correct
    public boolean isOverviewTitleDisplayed() {
        try {
            WebElement titleElement = driver.findElement(overviewTitle);
            // Explicitly assert the text after finding the element
            return doGetText(titleElement).equals("Checkout: Overview");
        } catch (Exception e) {
            // If the element isn't found, return false instead of letting the test crash immediately
            return false;
        }
    }

    // --- ACTION METHODS ---
    public CheckoutCompletePage clickFinish() {
        WebElement finishBtn = driver.findElement(finishButton);
        doClick(finishBtn);
        return new CheckoutCompletePage(driver);
    }
}
