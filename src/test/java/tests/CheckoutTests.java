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

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThePageTitle() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        Assert.assertEquals(driver.getTitle(),
                "Swag Labs",
                "Title of the page should be 'Swag Labs'.");
    }

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTheTitleInHeader() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        Assert.assertEquals(checkoutPage.getHeaderText(),
                "Swag Labs",
                "Title in the header should be 'Swag Labs'.");
    }

    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatBurgerMenuButtonIsPresent() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        Assert.assertTrue(headerPage.doesBurgerMenuButtonExist(),
                "Burger menu button should be present.");
    }

    @Test(priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatCartIconIsPresent() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        Assert.assertTrue(headerPage.doesCartIconExist(),
                "Cart icon should be present.");
    }

    @Test(priority = 6, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatBurgerMenuButtonIsEnabled() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        Assert.assertTrue(headerPage.getBurgerMenuButton().isEnabled(),
                "Burger menu button should be enabled.");
    }

    @Test(priority = 7, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatCartIconIsEnabled() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        Assert.assertTrue(headerPage.getCartIcon().isEnabled(),
                "Cart icon should be enabled.");
    }

    @Test(priority = 8, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatBurgerMenuButtonIsWorking() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeVisible();
    }

    @Test(priority = 9, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatCartIconIsWorking() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        headerPage.clickOnCartIcon();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "cart.html",
                "User should be redirected to the cart page.");
    }

    @Test(priority = 10, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatCartIconHasCorrectNumberOfAddedItems() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        Assert.assertEquals(headerPage.getNumberOfProductsInCart(), "",
                "Cart should be empty.");
    }

    @Test(priority = 11, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTheTotalNumberOfOptionsInBurgerMenu() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeVisible();
        Assert.assertEquals(leftNavPage.getNumberOfBurgerMenuOptions(), 4,
                "Number of options in burger menu should be 4.");
    }

    @Test(priority = 12, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTheSpellingOfAllOptionsInBurgerMenu() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeVisible();
        Assert.assertTrue(leftNavPage.checkSpellingOfAllOptionsInBurgerMenu(),
                "Options in burger menu are not spelled correctly.");
    }

    @Test(priority = 13, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatAllItemsOptionFromBurgerMenuIsWorking() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeVisible();
        leftNavPage.clickOnAllItemsLink();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "inventory.html",
                "User should be redirected to the products page.");
    }

    @Test(priority = 14, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatAboutOptionFromBurgerMenuIsWorking() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeVisible();
        leftNavPage.clickOnAboutLink();
        Assert.assertEquals(driver.getCurrentUrl(), "https://saucelabs.com/",
                "User should be redirected to the Sauce Labs website.");
    }

    @Test(priority = 15, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatLogoutOptionFromBurgerMenuIsWorking() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeVisible();
        leftNavPage.clickOnLogoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl,
                "User should be redirected to the login page.");
    }

    @Test(priority = 16, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatResetAppStateOptionFromBurgerMenuIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(3);
        inventoryPage.clickOnAddToCartButtonWithIndex(2);
        Assert.assertEquals(headerPage.getNumberOfProductsInCartInt(), 2,
                "Number of products added to the cart should be 2.");
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeVisible();
        leftNavPage.clickOnResetAppButton();
        Assert.assertEquals(headerPage.getNumberOfProductsInCart(), "",
                "Cart should be empty.");
    }

    @Test(priority = 17, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatExitButtonFromBurgerMenuIsPresent() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilExitButtonIsVisible();
    }

    @Test(priority = 18, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatExitButtonFromBurgerMenuIsWorking() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilExitButtonIsVisible();
        leftNavPage.clickOnExitButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeInvisible();
    }

    @Test(priority = 19, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTheSubHeaderTitle() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        Assert.assertEquals(checkoutPage.getSubHeaderTitleText(), "Checkout: Your Information",
                "Title from sub-header should be 'Checkout: Your Information'.");
    }

    @Test(priority = 20, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatFirstNameFieldIsPresent() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.waitUntilFirstNameFieldIsVisible();
    }

    @Test(priority = 21, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatLastNameFieldIsPresent() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.waitUntilLastNameFieldIsVisible();
    }

    @Test(priority = 22, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatZipCodeFieldIsPresent() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.waitUntilZipCodeFieldIsVisible();
    }

    @Test(priority = 23, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatFirstNameFieldIsEnabled() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.waitUntilFirstNameFieldIsVisible();
        Assert.assertTrue(checkoutPage.getFirstNameField().isEnabled(),
                "First name field should be enabled.");
    }

    @Test(priority = 24, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatLastNameFieldIsEnabled() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.waitUntilLastNameFieldIsVisible();
        Assert.assertTrue(checkoutPage.getLastNameField().isEnabled(),
                "Last name field should be enabled.");
    }

    @Test(priority = 25, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatZipCodeFieldIsEnabled() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.waitUntilZipCodeFieldIsVisible();
        Assert.assertTrue(checkoutPage.getZipCodeField().isEnabled(),
                "Zip code field should be enabled.");
    }

    @Test(priority = 26, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyValidInformationInput() {

        String firstName = "Aki";
        String lastName = "Akic";
        String zipCode = "11000";

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillInFirstNameField(firstName);
        checkoutPage.fillInLastNameField(lastName);
        checkoutPage.fillInZipCodeField(zipCode);
        checkoutPage.clickOnContinueButton();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "checkout-step-two.html",
                "User should be redirected to the payment page.");
    }

    @Test(priority = 27, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatUserCantCheckoutWithoutZipCode() {

        String firstName = "Aki";
        String lastName = "Akic";
        String zipCode = "";

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillInFirstNameField(firstName);
        checkoutPage.fillInLastNameField(lastName);
        checkoutPage.fillInZipCodeField(zipCode);
        checkoutPage.clickOnContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessageText(), "Error: Postal Code is required",
                "Text of error message should be 'Error: Postal Code is required'.");
    }

    @Test(priority = 28, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatUserCantCheckoutWithoutFirstName() {

        String firstName = "";
        String lastName = "Akic";
        String zipCode = "11000";

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillInFirstNameField(firstName);
        checkoutPage.fillInLastNameField(lastName);
        checkoutPage.fillInZipCodeField(zipCode);
        checkoutPage.clickOnContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessageText(), "Error: First Name is required",
                "Text of error message should be 'Error: First Name is required'.");
    }
}
