package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class ConfirmationTests extends BasicTest {

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTheUrl() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        paymentPage.clickOnFinishButton();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "checkout-complete.html",
                "Current url should be " + baseUrl + " checkout-complete.html");
    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTheTitle() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        paymentPage.clickOnFinishButton();
        Assert.assertEquals(driver.getTitle(), "Swag Labs",
                "Title for this page should be 'Swag Labs'.");
    }

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTheTitleInHeader() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(1);
        headerPage.clickOnCartIcon();
        cartPage.waitForCartPageToContainAddedProducts();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        paymentPage.clickOnFinishButton();
        Assert.assertEquals(confirmationPage.getHeaderTitleText(), "Swag Labs",
                "Title for this page should be 'Swag Labs'.");
    }

    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatBurgerMenuButtonIsPresent() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(0);
        headerPage.clickOnCartIcon();
        cartPage.waitForCartPageToContainAddedProducts();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        paymentPage.clickOnFinishButton();
        Assert.assertTrue(headerPage.doesBurgerMenuButtonExist(),
                "Burger menu button should exist on the page.");
    }

    @Test(priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatCartIconIsPresent() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(2);
        headerPage.clickOnCartIcon();
        cartPage.waitForCartPageToContainAddedProducts();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        paymentPage.clickOnFinishButton();
        Assert.assertTrue(headerPage.doesCartIconExist(),
                "Cart icon should exist on the page.");
    }

    @Test(priority = 6, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatBurgerMenuButtonIsEnabled() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(5);
        headerPage.clickOnCartIcon();
        cartPage.waitForCartPageToContainAddedProducts();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        paymentPage.clickOnFinishButton();
        Assert.assertTrue(headerPage.getBurgerMenuButton().isEnabled(),
                "Burger menu button should be enabled.");
    }

    @Test(priority = 7, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatCartIconIsEnabled() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(3);
        headerPage.clickOnCartIcon();
        cartPage.waitForCartPageToContainAddedProducts();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        paymentPage.clickOnFinishButton();
        Assert.assertTrue(headerPage.getCartIcon().isEnabled(),
                "Cart icon should be enabled.");
    }

    @Test(priority = 8, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatBurgerMenuButtonIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(1);
        headerPage.clickOnCartIcon();
        cartPage.waitForCartPageToContainAddedProducts();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        paymentPage.clickOnFinishButton();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeVisible();
    }

    @Test(priority = 9, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatCartIconIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(4);
        headerPage.clickOnCartIcon();
        cartPage.waitForCartPageToContainAddedProducts();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        paymentPage.clickOnFinishButton();
        headerPage.clickOnCartIcon();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "cart.html",
                "User should be redirected to the cart page.");
    }

    @Test(priority = 10, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatCartIconHasCorrectNumberOfAddedProducts() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(0);
        headerPage.clickOnCartIcon();
        cartPage.waitForCartPageToContainAddedProducts();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        paymentPage.clickOnFinishButton();
        Assert.assertEquals(headerPage.getNumberOfProductsInCart(), "",
                "Cart icon should be empty.");
    }

    @Test(priority = 11, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTheSubHeaderTitle() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(2);
        headerPage.clickOnCartIcon();
        cartPage.waitForCartPageToContainAddedProducts();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        paymentPage.clickOnFinishButton();
        Assert.assertEquals(confirmationPage.getSubHeaderTitleText(), "Checkout: Complete!",
                "Sub title header for cart page should be 'Checkout: Complete!'");
    }

    @Test(priority = 12, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTotalNumberOfOptionsInBurgerMenu() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(5);
        headerPage.clickOnCartIcon();
        cartPage.waitForCartPageToContainAddedProducts();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        paymentPage.clickOnFinishButton();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeVisible();
        Assert.assertEquals(leftNavPage.getNumberOfBurgerMenuOptions(), 4,
                "Burger menu should contain 4 options.");
    }

    @Test(priority = 13, retryAnalyzer = RetryAnalyzer.class)
    public void VerifySpellingOfAllOptionsInBurgerMenu() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(3);
        headerPage.clickOnCartIcon();
        cartPage.waitForCartPageToContainAddedProducts();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        paymentPage.clickOnFinishButton();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeVisible();
        Assert.assertTrue(leftNavPage.checkSpellingOfAllOptionsInBurgerMenu(),
                "Spelling of elements in burger menu is not correct.");
    }
}
