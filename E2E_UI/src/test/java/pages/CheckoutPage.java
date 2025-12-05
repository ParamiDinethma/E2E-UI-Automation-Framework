package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {

    // --- LOCATORS ---
    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By zipCodeField = By.id("postal-code");
    private final By continueButton = By.id("continue");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    // --- ACTION METHODS ---
    public void enterInformation(String firstName, String lastName, String zipCode) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(zipCodeField).sendKeys(zipCode);
    }

    // Action method to transition to the next page
    public CheckoutOverviewPage clickContinue() {
        WebElement continueBtn = driver.findElement(continueButton);
        doClick(continueBtn);
        return new CheckoutOverviewPage(driver);
    }
}
