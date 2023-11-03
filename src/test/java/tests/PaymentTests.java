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

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTheTitleInHeader() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        Assert.assertEquals(paymentPage.getHeaderText(), "Swag Labs",
                "Title for this page should be 'Swag Labs'.");
    }

    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatBurgerMenuButtonIsPresent() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        Assert.assertTrue(headerPage.doesBurgerMenuButtonExist(),
                "Burger menu button should exist on the page.");
    }

    @Test(priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatCartIconIsPresent() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        Assert.assertTrue(headerPage.doesCartIconExist(),
                "Cart icon should exist on the page.");
    }

    @Test(priority = 6, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatBurgerMenuButtonIsEnabled() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        Assert.assertTrue(headerPage.getBurgerMenuButton().isEnabled(),
                "Burger menu button should be enabled.");
    }

    @Test(priority = 7, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatCartIconIsEnabled() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        Assert.assertTrue(headerPage.getCartIcon().isEnabled(),
                "Cart icon should be enabled.");
    }

    @Test(priority = 8, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatBurgerMenuButtonIsWorking() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeVisible();
    }

    @Test(priority = 9, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatCartIconIsWorking() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        headerPage.clickOnCartIcon();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "cart.html",
                "User should be redirected to the cart page.");
    }

    @Test(priority = 10, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatCartIconHasCorrectNumberOfAddedProducts() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        Assert.assertEquals(headerPage.getNumberOfProductsInCart(), "",
                "Cart should be empty.");
    }

    @Test(priority = 11, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTheSubHeaderTitle() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        Assert.assertEquals(paymentPage.getSubHeaderTitleText(), "Checkout: Overview",
                "Sub title header should be 'Checkout: Overview'.");
    }

    @Test(priority = 12, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTotalNumberOfOptionsInBurgerMenu() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeVisible();
        Assert.assertEquals(leftNavPage.getNumberOfBurgerMenuOptions(), 4,
                "Burger menu should contain 4 options.");
    }

    @Test(priority = 13, retryAnalyzer = RetryAnalyzer.class)
    public void VerifySpellingOfAllOptionsInBurgerMenu() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeVisible();
        Assert.assertTrue(leftNavPage.checkSpellingOfAllOptionsInBurgerMenu(),
                "Spelling of elements in burger menu is not valid.");
    }

    @Test(priority = 14, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatAllItemsOptionFromBurgerMenuIsWorking() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeVisible();
        leftNavPage.clickOnAllItemsLink();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "inventory.html",
                "User should be redirected to the products page.");
    }

    @Test(priority = 15, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatAboutOptionFromBurgerMenuIsWorking() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeVisible();
        leftNavPage.clickOnAboutLink();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://saucelabs.com/",
                "User should be redirected to the Sauce Labs Website.");
    }

    @Test(priority = 16, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatLogoutOptionFromBurgerMenuIsWorking() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeVisible();
        leftNavPage.clickOnLogoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl,
                "User should be redirected to the login page.");
    }

    @Test(priority = 17, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatResetAppOptionFromBurgerMenuIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(2);
        Assert.assertEquals(headerPage.getNumberOfProductsInCartInt(), 1,
                "Number of products in cart should be 1.");
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeVisible();
        leftNavPage.clickOnResetAppButton();
        Assert.assertEquals(headerPage.getNumberOfProductsInCart(), "",
                "Cart should be empty.");
    }

    @Test(priority = 18, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatExitButtonFromBurgerMenuIsVisible() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilExitButtonIsVisible();
    }

    @Test(priority = 19, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatExitButtonFromBurgerMenuIsWorking() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilExitButtonIsVisible();
        leftNavPage.clickOnExitButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeInvisible();
    }

    @Test(priority = 20, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatItemsAddedToTheCartAreVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(3);
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        paymentPage.waitForAddedProductsToBeVisibleOnThePage();
    }

    @Test(priority = 21, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTheTotalNumberOfItemsAddedToTheCart() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(4);
        inventoryPage.clickOnAddToCartButtonWithIndex(1);
        inventoryPage.clickOnAddToCartButtonWithIndex(5);
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        Assert.assertEquals(paymentPage.getProductsAddedToTheCart().size(),
                headerPage.getNumberOfProductsInCartInt(),
                "Number of added products to the cart and on the payment page should be equal.");
    }

    @Test(priority = 22, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatItemsTitlesAddedToTheCartAreVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(2);
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        paymentPage.waitForAddedProductsTitlesToBeVisibleOnThePage();
    }

    @Test(priority = 23, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatItemsDescriptionsAddedToTheCartAreVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(3);
        inventoryPage.clickOnAddToCartButtonWithIndex(0);
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        paymentPage.waitForAddedProductsDescriptionsToBeVisibleOnThePage();
    }

    @Test(priority = 24, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatItemsPricesAddedToTheCartAreVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(1);
        inventoryPage.clickOnAddToCartButtonWithIndex(5);
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        paymentPage.waitForAddedProductsPricesToBeVisibleOnThePage();
    }

    @Test(priority = 25, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatItemsQuantitiesAreVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(3);
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        paymentPage.waitForAddedProductsQuantitiesToBeVisibleOnThePage();
    }

    @Test(priority = 26, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatItemsTitleIsClickable() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(5);
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        paymentPage.waitUntilItemsTitleIsClickable(0);
    }

    @Test(priority = 27, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatItemsTitleIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(0);
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        paymentPage.waitUntilItemsTitleIsClickable(0);
        paymentPage.clickOnItemsTitle(0);
        Assert.assertTrue(driver.getCurrentUrl().contains("item"),
                "User should be redirected to the item page.");
    }

    @Test(priority = 28, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThePaymentInformation() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(4);
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        Assert.assertEquals(paymentPage.getPaymentInformationText(), "Payment Information",
                "Payment information isn't spelled correctly.");
    }

    @Test(priority = 29, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTheShippingInformation() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(1);
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        Assert.assertEquals(paymentPage.getShippingInformationText(), "Shipping Information",
                "Shipping information isn't spelled correctly.");
    }
}
