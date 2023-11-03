package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class PaymentTests extends BasicTest {

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTheUrl() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "checkout-step-two.html",
                "Current url should be " + baseUrl + "checkout-step-two.html");
    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTheTitle() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(3);
        headerPage.clickOnCartIcon();
        cartPage.waitForCartPageToContainAddedProducts();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        Assert.assertEquals(driver.getTitle(), "Swag Labs",
                "Title for this page should be 'Swag Labs'.");
    }
}
