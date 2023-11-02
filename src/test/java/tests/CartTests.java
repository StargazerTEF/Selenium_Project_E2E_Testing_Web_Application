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

    @Test(priority = 11, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTheSubHeaderTitle() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        Assert.assertEquals(cartPage.getSubHeaderTitleText(), "Your Cart",
                "Sub header title should be 'Your Cart'.");
    }

    @Test(priority = 12, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTotalNumberOfOptionsInBurgerMenu() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeVisible();
        Assert.assertEquals(leftNavPage.getNumberOfBurgerMenuOptions(), 4,
                "Burger menu should contain 4 options.");
    }

    @Test(priority = 13, retryAnalyzer = RetryAnalyzer.class)
    public void VerifySpellingOfAllOptionsInLeftNavigationMenu() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeVisible();
        Assert.assertTrue(leftNavPage.checkSpellingOfAllOptionsInBurgerMenu(),
                "Spelling of elements in burger menu is not valid.");
    }

    @Test(priority = 14, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatAllItemsOptionFromBurgerMenuIsWorking() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeVisible();
        leftNavPage.clickOnAllItemsLink();
        Assert.assertEquals(inventoryPage.getSubTitleText(), "Products",
                "User should be redirected to the inventory page.");
    }

    @Test(priority = 15, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatAboutOptionFromBurgerMenuIsWorking() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
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
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeVisible();
        leftNavPage.clickOnLogoutButton();
        Assert.assertTrue(loginPage.doesUsernameFieldExist(),
                "User should be redirected to the login page.");
    }

    @Test(priority = 17, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatResetAppOptionFromBurgerMenuIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.waitUntilItemsAddToCartButtonsAreVisible();
        inventoryPage.clickOnAddToCartButtonWithIndex(0);
        Assert.assertEquals(headerPage.getNumberOfProductsInCartInt(), 1,
                "Number of products in cart should be 1.");
        headerPage.clickOnCartIcon();
        cartPage.waitForCartPageToContainAddedProducts();
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
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilExitButtonIsVisible();
    }

    @Test(priority = 19, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatExitButtonFromBurgerMenuIsWorking() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
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
        cartPage.waitForCartPageToContainAddedProducts();
    }

    @Test(priority = 21, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatItemsTitleAddedToTheCartIsVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(2);
        headerPage.clickOnCartIcon();
        cartPage.waitForAddedProductsTitlesToBeVisibleOnThePage();
    }

    @Test(priority = 22, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatItemsDescriptionAddedToTheCartIsVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(5);
        headerPage.clickOnCartIcon();
        cartPage.waitForAddedProductsDescriptionsToBeVisibleOnThePage();
    }

    @Test(priority = 23, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatItemsPriceAddedToTheCartIsVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(0);
        headerPage.clickOnCartIcon();
        cartPage.waitForAddedProductsPricesToBeVisibleOnThePage();
    }

    @Test(priority = 24, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatItemsQuantityIsVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(4);
        headerPage.clickOnCartIcon();
        cartPage.waitForAddedProductsQuantityToBeVisibleOnThePage();
    }

    @Test(priority = 25, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatItemsTitleIsClickable() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(1);
        headerPage.clickOnCartIcon();
        cartPage.waitUntilItemsTitleIsClickable(0);
    }

    @Test(priority = 26, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatItemsTitleIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(3);
        headerPage.clickOnCartIcon();
        cartPage.waitUntilItemsTitleIsClickable(0);
        cartPage.clickOnItemsTitle(0);
        Assert.assertTrue(driver.getCurrentUrl().contains("item"),
                "Current url should contain 'item'.");
    }

    @Test(priority = 27, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatRemoveButtonIsVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(2);
        headerPage.clickOnCartIcon();
        cartPage.waitUntilRemoveButtonIsVisibleWIthIndex(0);
    }

    @Test(priority = 28, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatRemoveButtonIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(1);
        headerPage.clickOnCartIcon();
        Assert.assertEquals(headerPage.getNumberOfProductsInCartInt(), 1,
                "Number of products in cart should be 1.");
        cartPage.waitUntilRemoveButtonIsVisibleWIthIndex(0);
        cartPage.clickOnRemoveButtonWithIndex(0);
        Assert.assertEquals(headerPage.getNumberOfProductsInCart(), "",
                "Cart should be empty.");
    }

    @Test(priority = 29, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatContinueShoppingButtonIsVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(0);
        headerPage.clickOnCartIcon();
        cartPage.waitUntilContinueShoppingButtonIsVisible();
    }

    @Test(priority = 30, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatContinueShoppingButtonIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(5);
        headerPage.clickOnCartIcon();
        cartPage.waitUntilContinueShoppingButtonIsVisible();
        cartPage.clickOnContinueShoppingButton();
        Assert.assertEquals(inventoryPage.getSubTitleText(), "Products",
                "User should be redirected to the inventory page.");
    }

    @Test(priority = 31, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatCheckoutButtonIsVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(3);
        headerPage.clickOnCartIcon();
        cartPage.waitUntilCheckoutButtonIsVisible();
    }

    @Test(priority = 32, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatCheckoutButtonIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(4);
        headerPage.clickOnCartIcon();
        cartPage.waitUntilCheckoutButtonIsVisible();
        cartPage.clickOnCheckoutButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout"),
                "Current url should contain 'checkout'.");
    }

    @Test(priority = 33, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatTwitterIconIsVisible() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        footerPage.waitUntilTwitterIconIsVisible();
    }

    @Test(priority = 34, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatFacebookIconIsVisible() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        footerPage.waitUntilFacebookIconIsVisible();
    }

    @Test(priority = 35, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatLinkedInIconIsVisible() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        footerPage.waitUntilLinkedInIconIsVisible();
    }

    @Test(priority = 36, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatTwitterIconIsWorking() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        footerPage.waitUntilTwitterIconIsVisible();
        footerPage.clickOnTwitterIcon();
        footerPage.switchToNewTab();
        Assert.assertTrue(driver.getCurrentUrl().contains("twitter"),
                "Current url should contain 'twitter'.");
    }

    @Test(priority = 37, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatFacebookIconIsWorking() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        footerPage.waitUntilFacebookIconIsVisible();
        footerPage.clickOnFacebookIcon();
        footerPage.switchToNewTab();
        Assert.assertTrue(driver.getCurrentUrl().contains("facebook"),
                "Current url should contain 'facebook'.");
    }
}
