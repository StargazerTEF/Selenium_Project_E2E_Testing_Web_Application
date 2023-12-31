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

    @Test(priority = 29, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatUserCantCheckoutWithoutLastName() {

        String firstName = "Aki";
        String lastName = "";
        String zipCode = "11000";

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillInFirstNameField(firstName);
        checkoutPage.fillInLastNameField(lastName);
        checkoutPage.fillInZipCodeField(zipCode);
        checkoutPage.clickOnContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessageText(), "Error: Last Name is required",
                "Text of error message should be 'Error: Last Name is required'.");
    }

    @Test(priority = 30, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatUserCantCheckoutWithoutLastNameAndZipCode() {

        String firstName = "Aki";
        String lastName = "";
        String zipCode = "";

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillInFirstNameField(firstName);
        checkoutPage.fillInLastNameField(lastName);
        checkoutPage.fillInZipCodeField(zipCode);
        checkoutPage.clickOnContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessageText(), "Error: Last Name is required",
                "Text of error message should be 'Error: Last Name is required'.");
    }

    @Test(priority = 31, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatUserCantCheckoutWithoutFirstNameAndZipCode() {

        String firstName = "";
        String lastName = "Akic";
        String zipCode = "";

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

    @Test(priority = 32, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatUserCantCheckoutWithoutFirstNameAndLastName() {

        String firstName = "";
        String lastName = "";
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

    @Test(priority = 33, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatUserCantCheckoutWithAllFieldsLeftBlank() {

        String firstName = "";
        String lastName = "";
        String zipCode = "";

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

    @Test(priority = 34, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatUserCantCheckoutWithFirstNameFieldContainingNumbers() {

        String firstName = "123";
        String lastName = "Akic";
        String zipCode = "11000";

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillInFirstNameField(firstName);
        checkoutPage.fillInLastNameField(lastName);
        checkoutPage.fillInZipCodeField(zipCode);
        checkoutPage.clickOnContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessageText(), "Error: First Name is Invalid",
                "Text of error message should be 'Error: First Name is Invalid'.");
    }

    @Test(priority = 35, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatUserCantCheckoutWithLastNameFieldContainingNumbers() {

        String firstName = "Aki";
        String lastName = "123";
        String zipCode = "11000";

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillInFirstNameField(firstName);
        checkoutPage.fillInLastNameField(lastName);
        checkoutPage.fillInZipCodeField(zipCode);
        checkoutPage.clickOnContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessageText(), "Error: Last Name is Invalid",
                "Text of error message should be 'Error: Last Name is Invalid'.");
    }

    @Test(priority = 36, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatUserCanSuccessfullyCheckoutWithZipCodeFieldContainingNumbers() {

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

    @Test(priority = 37, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatUserCantCheckoutWithFirstNameFieldContainingSpecialCharacters() {

        String firstName = "@";
        String lastName = "Akic";
        String zipCode = "11000";

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillInFirstNameField(firstName);
        checkoutPage.fillInLastNameField(lastName);
        checkoutPage.fillInZipCodeField(zipCode);
        checkoutPage.clickOnContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessageText(), "Error: First Name is Invalid",
                "Text of error message should be 'Error: First Name is Invalid'.");
    }

    @Test(priority = 38, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatUserCantCheckoutWithLastNameFieldContainingSpecialCharacters() {

        String firstName = "Aki";
        String lastName = "@";
        String zipCode = "11000";

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillInFirstNameField(firstName);
        checkoutPage.fillInLastNameField(lastName);
        checkoutPage.fillInZipCodeField(zipCode);
        checkoutPage.clickOnContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessageText(), "Error: Last Name is Invalid",
                "Text of error message should be 'Error: Last Name is Invalid'.");
    }

    @Test(priority = 39, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatUserCantCheckoutWithZipCodeFieldContainingSpecialCharacters() {

        String firstName = "Aki";
        String lastName = "Akic";
        String zipCode = "@";

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillInFirstNameField(firstName);
        checkoutPage.fillInLastNameField(lastName);
        checkoutPage.fillInZipCodeField(zipCode);
        checkoutPage.clickOnContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessageText(), "Error: Zip Code is Invalid",
                "Text of error message should be 'Error: Zip Code is Invalid'.");
    }

    @Test(priority = 40, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatCancelButtonIsPresent() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.waitUntilCancelButtonIsVisible();
    }

    @Test(priority = 41, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatCancelButtonIsEnabled() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        Assert.assertTrue(checkoutPage.getCancelButton().isEnabled(),
                "Cancel button should be enabled.");
    }

    @Test(priority = 42, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatCancelButtonIsWorking() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.clickOnCancelButton();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "cart.html",
                "User should be redirected to the cart page.");
    }

    @Test(priority = 43, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatContinueButtonIsPresent() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        checkoutPage.waitUntilContinueButtonIsVisible();
    }

    @Test(priority = 44, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatContinueButtonIsEnabled() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        Assert.assertTrue(checkoutPage.getContinueButton().isEnabled(),
                "Continue button should be enabled.");
    }

    @Test(priority = 45, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatContinueButtonIsWorking() {

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

    @Test(priority = 46, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatTwitterButtonIsPresent() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        footerPage.waitUntilTwitterIconIsVisible();
    }

    @Test(priority = 47, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatFacebookButtonIsPresent() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        footerPage.waitUntilFacebookIconIsVisible();
    }

    @Test(priority = 48, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatLinkedInButtonIsPresent() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        footerPage.waitUntilLinkedInIconIsVisible();
    }

    @Test(priority = 49, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatTwitterButtonIsWorking() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        footerPage.waitUntilTwitterIconIsVisible();
        footerPage.clickOnTwitterIcon();
        footerPage.switchToNewTab();
        Assert.assertTrue(driver.getCurrentUrl().contains("twitter"),
                "Current url should contain 'twitter'.");
    }

    @Test(priority = 50, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatFacebookButtonIsWorking() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        footerPage.waitUntilFacebookIconIsVisible();
        footerPage.clickOnFacebookIcon();
        footerPage.switchToNewTab();
        Assert.assertTrue(driver.getCurrentUrl().contains("facebook"),
                "Current url should contain 'facebook'.");
    }

    @Test(priority = 51, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatLinkedInButtonIsWorking() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        footerPage.waitUntilLinkedInIconIsVisible();
        footerPage.clickOnLinkedInIcon();
        footerPage.switchToNewTab();
        Assert.assertTrue(driver.getCurrentUrl().contains("linkedin"),
                "Current url should contain 'linkedin'.");
    }

    @Test(priority = 52, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatCopyrightNoticeMessageIsCorrect() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        cartPage.clickOnCheckoutButton();
        Assert.assertEquals(footerPage.getCopyRightMessageText(),
                "© 2023 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy",
                "Copyright notice message in footer should be '© 2023 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy'.");
    }
}
