package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import pages.CartPage;
import pages.CheckoutPage;
import pages.CheckoutOverviewPage;
import pages.CheckoutCompletePage;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        // Initialize the Chrome WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Instantiate the LoginPage object
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 2, description = "Verify error message for invalid credentials")
    public void testFailedLogin() {
        // Use known invalid credentials
        loginPage.performLogin("bad_user", "bad_password");

        // ASSERTION: Check if the expected error message is displayed
        String expectedError = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(loginPage.getErrorMessage(), expectedError, "Error message text is incorrect or not displayed.");
    }

    @Test(priority = 1, description = "Verify successful login with valid credentials")
    public void testSuccessfulLogin() {
        // 1. Action: Perform login and get the ProductsPage object
        ProductsPage productsPage = loginPage.loginSuccess("standard_user", "secret_sauce");

        // 2. Assertion: Check if the Products header is displayed
        Assert.assertTrue(productsPage.isProductsHeaderDisplayed(), "Login failed! Products page header not visible.");
    }

    @Test(priority = 3, description = "Verify full E2E flow: Login, Add Item, Navigate to Cart")
    public void testFullE2EAddItem() {

        // 1. LOGIN & LAND ON PRODUCTS PAGE (Use the method that returns ProductsPage)
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.loginSuccess("standard_user", "secret_sauce");

        // Assertion to ensure we landed correctly (already covered by priority 1, but good for E2E)
        Assert.assertTrue(productsPage.isProductsHeaderDisplayed(), "Precondition failed: Not on Products page.");

        // 2. ADD ITEM TO CART
        productsPage.addBackpackToCart();

        // 3. NAVIGATE TO CART PAGE
        CartPage cartPage = productsPage.navigateToCart();

        // 4. ASSERTION: VERIFY ITEM IN CART
        Assert.assertTrue(cartPage.isBackpackItemDisplayed(), "E2E Failure: Item was not found in the shopping cart.");
        Assert.assertEquals(cartPage.getBackpackItemName(), "Sauce Labs Backpack", "E2E Failure: Incorrect item added to cart.");

        // 5. PROCEED TO CHECKOUT (Optional for this test, but shows next step)
        // CheckoutPage checkoutPage = cartPage.clickCheckout();
    }

    @Test(priority = 4, description = "Full Purchase Flow: Login, Add Item, Checkout, and Complete Order")
    public void testFullE2EPurchaseFlow() {
        // 1. LOGIN & ADD ITEM
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.loginSuccess("standard_user", "secret_sauce");
        productsPage.addBackpackToCart();
        CartPage cartPage = productsPage.navigateToCart();

        // 2. START CHECKOUT
        CheckoutPage checkoutPage = cartPage.clickCheckout();

        // 3. ENTER INFORMATION
        checkoutPage.enterInformation("Test", "User", "90210");

        // 4. GO TO OVERVIEW
        CheckoutOverviewPage overviewPage = checkoutPage.clickContinue();
        Assert.assertTrue(overviewPage.isOverviewTitleDisplayed(), "Failed to reach Checkout Overview page.");
        // TEMPORARY: Print the current URL to see where the browser landed
        System.out.println("Browser landed on: " + driver.getCurrentUrl());
        // 5. FINISH ORDER
        CheckoutCompletePage completePage = overviewPage.clickFinish();

        // 6. FINAL ASSERTION: ORDER SUCCESSFUL
        Assert.assertTrue(completePage.isOrderSuccessful(), "Order was not successfully completed. 'Thank You' message not found.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Close the browser after each test method
        }
    }
}