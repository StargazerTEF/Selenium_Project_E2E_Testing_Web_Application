package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class CheckoutTests extends BasicTest {

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTheUrl() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "checkout-step-one.html",
                "Current url should be " + baseUrl + "checkout-step-one.html");
    }
}
