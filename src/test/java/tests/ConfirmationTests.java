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

    @Test(priority = 14, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatAllItemsOptionFromBurgerMenuIsWorking() {

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
        leftNavPage.clickOnAllItemsLink();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "inventory.html",
                "User should be redirected to the products page.");
    }

    @Test(priority = 15, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatAboutOptionFromBurgerMenuIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(4);
        headerPage.clickOnCartIcon();
        cartPage.waitForCartPageToContainAddedProducts();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        paymentPage.clickOnFinishButton();
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
        inventoryPage.clickOnAddToCartButtonWithIndex(2);
        headerPage.clickOnCartIcon();
        cartPage.waitForCartPageToContainAddedProducts();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        paymentPage.clickOnFinishButton();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeVisible();
        leftNavPage.clickOnLogoutButton();
        Assert.assertTrue(loginPage.doesUsernameFieldExist(),
                "User should be redirected to the login page.");
    }

    @Test(priority = 17, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatResetAppOptionFromBurgerMenuIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(0);
        Assert.assertEquals(headerPage.getNumberOfProductsInCartInt(), 1,
                "Number of products in cart should be 1.");
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        paymentPage.clickOnFinishButton();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeVisible();
        leftNavPage.clickOnResetAppButton();
    }

    @Test(priority = 18, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatExitButtonFromBurgerMenuIsVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(5);
        headerPage.clickOnCartIcon();
        cartPage.waitForCartPageToContainAddedProducts();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        paymentPage.clickOnFinishButton();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilExitButtonIsVisible();
    }

    @Test(priority = 19, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatExitButtonFromBurgerMenuIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(3);
        headerPage.clickOnCartIcon();
        cartPage.waitForCartPageToContainAddedProducts();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        paymentPage.clickOnFinishButton();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilExitButtonIsVisible();
        leftNavPage.clickOnExitButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeInvisible();
    }

    @Test(priority = 20, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatImageInConfirmationMessageIsVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(1);
        headerPage.clickOnCartIcon();
        cartPage.waitForCartPageToContainAddedProducts();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        paymentPage.clickOnFinishButton();
        confirmationPage.waitUntilConfirmationMessageImageIsVisible();
    }

    @Test(priority = 21, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyConfirmationMessageHeaderTextSpelling() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(4);
        headerPage.clickOnCartIcon();
        cartPage.waitForCartPageToContainAddedProducts();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        paymentPage.clickOnFinishButton();
        Assert.assertEquals(confirmationPage.getConfirmationMessageHeaderText(),
                "Thank you for your order!",
                "Confirmation message header text isn't spelled correctly.");
    }

    @Test(priority = 22, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyConfirmationMessageBodyTextSpelling() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(2);
        headerPage.clickOnCartIcon();
        cartPage.waitForCartPageToContainAddedProducts();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        paymentPage.clickOnFinishButton();
        Assert.assertEquals(confirmationPage.getConfirmationMessageBodyText(),
                "Your order has been dispatched, and will arrive just as fast as the pony can get there!",
                "Confirmation message body text isn't spelled correctly.");
    }

    @Test(priority = 23, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatBackHomeButtonIsVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(0);
        headerPage.clickOnCartIcon();
        cartPage.waitForCartPageToContainAddedProducts();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        paymentPage.clickOnFinishButton();
        confirmationPage.waitUntilBackHomeButtonIsVisible();
    }

    @Test(priority = 24, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatBackHomeButtonIsEnabled() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(4);
        headerPage.clickOnCartIcon();
        cartPage.waitForCartPageToContainAddedProducts();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        paymentPage.clickOnFinishButton();
        confirmationPage.waitUntilBackHomeButtonIsVisible();
        Assert.assertTrue(confirmationPage.getBackHomeButton().isEnabled(),
                "Back home button should be enabled.");
    }

    @Test(priority = 25, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatBackHomeButtonIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(5);
        headerPage.clickOnCartIcon();
        cartPage.waitForCartPageToContainAddedProducts();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        paymentPage.clickOnFinishButton();
        confirmationPage.waitUntilBackHomeButtonIsVisible();
        confirmationPage.clickOnBackHomeButton();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "inventory.html",
                "User should be redirected to the inventory page.");
    }

    @Test(priority = 26, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatTwitterIconIsVisible() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        paymentPage.clickOnFinishButton();
        footerPage.waitUntilTwitterIconIsVisible();
    }

    @Test(priority = 27, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatFacebookIconIsVisible() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillOutCheckoutFormWithValidInputs();
        checkoutPage.clickOnContinueButton();
        paymentPage.clickOnFinishButton();
        footerPage.waitUntilFacebookIconIsVisible();
    }
}
