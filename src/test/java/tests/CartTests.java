package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class CartTests extends BasicTest {

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTheUrl() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "cart.html",
                "Current url should be " + baseUrl + "cart.html");
    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTheTitle() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(4);
        headerPage.clickOnCartIcon();
        cartPage.waitForCartPageToContainAddedProducts();
        Assert.assertEquals(driver.getTitle(), "Swag Labs",
                "Title should be 'Swag Labs'.");
    }

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTheTitleInHeader() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        Assert.assertEquals(cartPage.getHeaderTitleText(), "Swag Labs",
                "Title in the header should be 'Swag Labs'.");
    }

    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatBurgerMenuButtonIsPresent() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        Assert.assertTrue(headerPage.doesBurgerMenuButtonExist(),
                "Burger menu button should exist on the page.");
    }

    @Test(priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatCartIconIsPresent() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        Assert.assertTrue(headerPage.doesCartIconExist(),
                "Cart icon should exist on the page.");
    }

    @Test(priority = 6, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatBurgerMenuButtonIsEnabled() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        Assert.assertTrue(headerPage.getBurgerMenuButton().isEnabled(),
                "Burger menu button should be enabled on the page.");
    }

    @Test(priority = 7, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatCartIconIsEnabled() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        Assert.assertTrue(headerPage.getCartIcon().isEnabled(),
                "Cart icon should be enabled on the page.");
    }

    @Test(priority = 8, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatBurgerMenuButtonIsWorking() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeVisible();
    }

    @Test(priority = 9, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatCartIconIsWorking() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"),
                "Current url should contain 'cart'.");
    }

    @Test(priority = 10, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatCartIconHasCorrectNumberOfAddedProducts() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        Assert.assertEquals(headerPage.getNumberOfProductsInCart(), "",
                "Cart should be empty.");
    }
}
