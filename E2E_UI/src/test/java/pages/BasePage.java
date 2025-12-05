package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    // Constructor to initialize the driver and wait object
    public BasePage(WebDriver driver) {
        this.driver = driver;
        // 10-second explicit wait for visibility
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Generic method to wait for and click an element
    public void doClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }

    // Generic method to wait for and type text into an input field
    public void doSendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    // Generic method to get the text of an element
    public String doGetText(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }
}
