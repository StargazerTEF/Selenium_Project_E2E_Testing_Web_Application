package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class ProductsTests extends BasicTest {

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyUrl() {

        loginPage.loginWIthValidCredentials();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "inventory.html",
                "Current url should be " + baseUrl + "inventory.html");
    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThePageTitle() {

        loginPage.loginWIthValidCredentials();
        Assert.assertEquals(driver.getTitle(),
                "Swag Labs",
                "Title of the page should be 'Swag Labs'.");
    }

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTheTitleInHeader() {

        loginPage.loginWIthValidCredentials();
        Assert.assertEquals(inventoryPage.getHeaderText(),
                "Swag Labs",
                "Title in header should be 'Swag Labs'.");
    }

    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatBurgerMenuButtonIsPresent() {

        loginPage.loginWIthValidCredentials();
        Assert.assertTrue(headerPage.doesBurgerMenuButtonExist(),
                "Burger menu button should be present.");
    }

    @Test(priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatCartIconIsPresent() {

        loginPage.loginWIthValidCredentials();
        Assert.assertTrue(headerPage.doesCartIconExist(),
                "Cart icon should be present.");
    }

    @Test(priority = 6, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatBurgerMenuButtonIsEnabled() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnBurgerMenuButton();
        Assert.assertTrue(headerPage.getBurgerMenuButton().isEnabled(),
                "Burger menu button should be enabled.");
    }

    @Test(priority = 7, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatCartIconIsEnabled() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        Assert.assertTrue(headerPage.getCartIcon().isEnabled(),
                "Cart icon should be enabled.");
    }

    @Test(priority = 8, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatBurgerMenuButtonIsWorking() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeVisible();
    }

    @Test(priority = 9, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatCartIconIsWorking() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnCartIcon();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "cart.html",
                "User should be redirected to the cart page.");
    }

    @Test(priority = 10, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatTheCartIconHasCorrectNumberOfAddedItems() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(3);
        inventoryPage.clickOnAddToCartButtonWithIndex(1);
        Assert.assertEquals(headerPage.getNumberOfProductsInCartInt(), 2,
                "Number of products added to the cart should be 2.");
    }

    @Test(priority = 11, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTheTotalNumberOfOptionsInBurgerMenu() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeVisible();
        Assert.assertEquals(leftNavPage.getNumberOfBurgerMenuOptions(), 4,
                "Number of options in burger menu should be 4.");
    }

    @Test(priority = 12, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTheSpellingOfAllOptionsInBurgerMenu() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeVisible();
        Assert.assertTrue(leftNavPage.checkSpellingOfAllOptionsInBurgerMenu(),
                "Options in burger menu are not spelled correctly.");
    }

    @Test(priority = 13, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatAllItemsOptionFromBurgerMenuIsWorking() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeVisible();
        leftNavPage.clickOnAllItemsLink();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "inventory.html",
                "User should be redirected to the products page.");
    }

    @Test(priority = 14, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatAboutOptionFromBurgerMenuIsWorking() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeVisible();
        leftNavPage.clickOnAboutLink();
        Assert.assertEquals(driver.getCurrentUrl(), "https://saucelabs.com/",
                "User should be redirected to the Sauce Labs website.");
    }

    @Test(priority = 15, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatLogoutOptionFromBurgerMenuIsWorking() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeVisible();
        leftNavPage.clickOnLogoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl,
                "User should be redirected to the login page.");
    }

    @Test(priority = 16, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatResetAppStateOptionFromBurgerMenuIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnAddToCartButtonWithIndex(4);
        inventoryPage.clickOnAddToCartButtonWithIndex(0);
        Assert.assertEquals(headerPage.getNumberOfProductsInCartInt(), 2,
                "Number of products added to the cart should be 2.");
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeVisible();
        leftNavPage.clickOnResetAppButton();
        Assert.assertEquals(headerPage.getNumberOfProductsInCart(), "",
                "Cart should be empty.");
    }

    @Test(priority = 17, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatTheExitButtonFromBurgerMenuIsPresent() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilExitButtonIsVisible();
    }

    @Test(priority = 18, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatTheExitButtonFromBurgerMenuIsWorking() {

        loginPage.loginWIthValidCredentials();
        headerPage.clickOnBurgerMenuButton();
        leftNavPage.waitUntilExitButtonIsVisible();
        leftNavPage.clickOnExitButton();
        leftNavPage.waitUntilBurgerMenuOptionsBecomeInvisible();
    }

    @Test(priority = 19, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTheSubHeaderTitle() {

        loginPage.loginWIthValidCredentials();
        Assert.assertEquals(inventoryPage.getSubTitleText(), "Products",
                "Title from sub-header should be 'Products'.");
    }

    @Test(priority = 20, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatTheFilterButtonIsPresent() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.waitUntilFilterButtonIsVisible();
    }

    @Test(priority = 21, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatTheFilterButtonIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.waitUntilFilterButtonIsVisible();
        inventoryPage.clickOnFilterButton();
        inventoryPage.waitUntilFilterMenuOptionsAreVisible();
    }

    @Test(priority = 22, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatAscendingNamesFilterIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.waitUntilFilterButtonIsVisible();
        inventoryPage.clickOnFilterButton();
        inventoryPage.waitUntilFilterMenuOptionsAreVisible();
        inventoryPage.clickOnAscendingNamesOptionFromFilterMenu();
        Assert.assertTrue(inventoryPage.isAscendingNamesFilterWorking(),
                "Ascending name filter is not working.");
    }

    @Test(priority = 23, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatDescendingNamesFilterIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.waitUntilFilterButtonIsVisible();
        inventoryPage.clickOnFilterButton();
        inventoryPage.waitUntilFilterMenuOptionsAreVisible();
        inventoryPage.clickOnDescendingNamesOptionFromFilterMenu();
        Assert.assertTrue(inventoryPage.isDescendingNamesFilterWorking(),
                "Descending name filter is not working.");
    }

    @Test(priority = 24, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatThePricesFromLowToHighFilterIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.waitUntilFilterButtonIsVisible();
        inventoryPage.clickOnFilterButton();
        inventoryPage.waitUntilFilterMenuOptionsAreVisible();
        inventoryPage.clickOnAscendingPricesOptionFromFilterMenu();
        Assert.assertTrue(inventoryPage.isAscendingPricesFilterWorking(),
                "Ascending prices filter is not working.");
    }

    @Test(priority = 25, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatThePricesFromHighToLowFilterIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.waitUntilFilterButtonIsVisible();
        inventoryPage.clickOnFilterButton();
        inventoryPage.waitUntilFilterMenuOptionsAreVisible();
        inventoryPage.clickOnDescendingPricesOptionFromFilterMenu();
        Assert.assertTrue(inventoryPage.isDescendingPricesFilterWorking(),
                "Descending prices filter is not working.");
    }

    @Test(priority = 26, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTheSpellingOfAllFilterOptions() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.waitUntilFilterButtonIsVisible();
        inventoryPage.clickOnFilterButton();
        inventoryPage.waitUntilFilterMenuOptionsAreVisible();
        Assert.assertTrue(inventoryPage.checkSpellingOfAllOptionsInFilterMenu(),
                "Options in filter menu are not spelled correctly.");
    }

    @Test(priority = 27, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTheTotalNumberOfFilterOptions() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.waitUntilFilterButtonIsVisible();
        inventoryPage.clickOnFilterButton();
        inventoryPage.waitUntilFilterMenuOptionsAreVisible();
        Assert.assertEquals(inventoryPage.getNumberOfFilterMenuOptions(), 4,
                "Number of filter menu options should be 4.");
    }

    @Test(priority = 28, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatItemsArePresent() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.waitUntilItemCardsAreVisible();
    }

    @Test(priority = 29, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTheTotalNumberOfItems() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.waitUntilItemCardsAreVisible();
        Assert.assertEquals(inventoryPage.getNumberOfItemCards(), 6,
                "Number of item cards should be 6.");
    }

    @Test(priority = 30, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatItemsTitlesAreVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.waitUntilItemsTitlesAreVisible();
    }

    @Test(priority = 31, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatItemsDescriptionsAreVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.waitUntilItemsDescriptionsAreVisible();
    }

    @Test(priority = 32, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatItemsPricesAreVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.waitUntilItemsPricesAreVisible();
    }

    @Test(priority = 33, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatItemsImagesAreVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.waitUntilItemsImagesAreVisible();
    }

    @Test(priority = 34, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatItemsAddToCartButtonsAreVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.waitUntilItemsAddToCartButtonsAreVisible();
    }

    @Test(priority = 35, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatItemsTitleIsClickable() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.waitUntilItemsTitleIsClickableWithIndex(3);
    }

    @Test(priority = 36, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatItemsTitleIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.waitUntilItemsTitleIsClickableWithIndex(2);
        inventoryPage.clickOnItemsTitleWithIndex(2);
        Assert.assertTrue(driver.getCurrentUrl().contains("item"),
                "User should be redirected to the item page.");
    }

    @Test(priority = 37, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatAddToCartButtonIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.waitUntilItemsAddToCartButtonsAreVisible();
        inventoryPage.clickOnAddToCartButtonWithIndex(4);
        Assert.assertEquals(headerPage.getNumberOfProductsInCartInt(), 1,
                "Number of products added to the cart should be 1.");
    }

    @Test(priority = 38, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatRemoveButtonIsVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.waitUntilItemsAddToCartButtonsAreVisible();
        inventoryPage.clickOnAddToCartButtonWithIndex(4);
        inventoryPage.waitUntilTextInItemsButtonBecomesRemove(4);
    }

    @Test(priority = 39, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatRemoveButtonIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.waitUntilItemsAddToCartButtonsAreVisible();
        inventoryPage.clickOnAddToCartButtonWithIndex(5);
        Assert.assertEquals(headerPage.getNumberOfProductsInCartInt(), 1,
                "Number of products added to the cart should be 1.");
        inventoryPage.clickOnRemoveButtonWithIndex(5);
        Assert.assertEquals(headerPage.getNumberOfProductsInCart(), "",
                "Cart should be empty.");
    }

    @Test(priority = 40, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatItemIsAddedToTheCartPageCorrectly() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.waitUntilItemsAddToCartButtonsAreVisible();
        inventoryPage.clickOnAddToCartButtonWithIndex(5);
        String titleOfTheItemAddedToTheCart = inventoryPage.getTitleOfTheItemAddedToTheCartWithIndex(5);
        headerPage.clickOnCartIcon();
        cartPage.waitForCartPageToContainAddedProducts();
        Assert.assertEquals(titleOfTheItemAddedToTheCart,
                cartPage.getTitleTextOfTheItemAddedToTheCartWithIndex(0),
                "Titles of the items should match.");
    }

    @Test(priority = 41, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatCartIconIsUpdatedWithTheNumberItDisplays() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.waitUntilItemsAddToCartButtonsAreVisible();
        inventoryPage.clickOnAddToCartButtonWithIndex(2);
        Assert.assertEquals(headerPage.getNumberOfProductsInCartInt(), 1,
                "Number in the card icon should be 1.");
    }

    @Test(priority = 42, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatItemsTitleIsVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnItemsTitleWithIndex(4);
        itemPage.waitUntilItemsTitleIsVisible();
    }

    @Test(priority = 43, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatItemsDescriptionIsVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnItemsTitleWithIndex(1);
        itemPage.waitUntilItemsDescriptionIsVisible();
    }

    @Test(priority = 44, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatItemsPriceIsVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnItemsTitleWithIndex(0);
        itemPage.waitUntilItemsPriceIsVisible();
    }

    @Test(priority = 45, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatItemsAddToCartButtonIsVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnItemsTitleWithIndex(3);
        itemPage.waitUntilItemsAddToCartButtonIsVisible();
    }

    @Test(priority = 46, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatItemsAddToCartButtonIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnItemsTitleWithIndex(5);
        itemPage.waitUntilItemsAddToCartButtonIsVisible();
        itemPage.clickOnItemsAddToCartButton();
        Assert.assertEquals(headerPage.getNumberOfProductsInCartInt(), 1,
                "Number of products added to cart should be 1.");
    }

    @Test(priority = 47, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatItemsRemoveButtonIsVisible() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnItemsTitleWithIndex(1);
        itemPage.waitUntilItemsAddToCartButtonIsVisible();
        itemPage.clickOnItemsAddToCartButton();
        Assert.assertEquals(headerPage.getNumberOfProductsInCartInt(), 1,
                "Number of products added to cart should be 1.");
        itemPage.waitUntilItemsButtonTextBecomesRemove();
    }

    @Test(priority = 48, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatItemsRemoveButtonIsWorking() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnItemsTitleWithIndex(4);
        itemPage.waitUntilItemsAddToCartButtonIsVisible();
        itemPage.clickOnItemsAddToCartButton();
        Assert.assertEquals(headerPage.getNumberOfProductsInCartInt(), 1,
                "Number of products added to cart should be 1.");
        itemPage.waitUntilItemsButtonTextBecomesRemove();
        itemPage.clickOnItemsRemoveButton();
        Assert.assertEquals(headerPage.getNumberOfProductsInCart(), "",
                "Cart should be empty.");
    }

    @Test(priority = 49, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatItemIsAddedToCartCorrectly() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnItemsTitleWithIndex(4);
        itemPage.waitUntilItemsAddToCartButtonIsVisible();
        itemPage.clickOnItemsAddToCartButton();
        headerPage.clickOnCartIcon();
        cartPage.waitForCartPageToContainAddedProducts();
    }

    @Test(priority = 50, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatCartIconIsUpdatedWhenItemsAreAddedToTheCart() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnItemsTitleWithIndex(2);
        itemPage.waitUntilItemsAddToCartButtonIsVisible();
        itemPage.clickOnItemsAddToCartButton();
        itemPage.clickOnBackToProductsButton();
        Assert.assertEquals(headerPage.getNumberOfProductsInCartInt(), 1,
                "Number of products added to cart should be 1.");
    }

    @Test(priority = 51, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatImagePresentInItem1IsCorrect() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnItemsTitleWithIndex(0);
        Assert.assertTrue(itemPage.isImageCorrectInItem(0),
                "Items image is not correct.");
    }

    @Test(priority = 52, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatImagePresentInItem2IsCorrect() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnItemsTitleWithIndex(1);
        Assert.assertTrue(itemPage.isImageCorrectInItem(1),
                "Items image is not correct.");
    }

    @Test(priority = 53, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatImagePresentInItem3IsCorrect() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnItemsTitleWithIndex(2);
        Assert.assertTrue(itemPage.isImageCorrectInItem(2),
                "Items image is not correct.");
    }

    @Test(priority = 54, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatImagePresentInItem4IsCorrect() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnItemsTitleWithIndex(3);
        Assert.assertTrue(itemPage.isImageCorrectInItem(3),
                "Items image is not correct.");
    }

    @Test(priority = 55, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyIfTheImagePresentInItem5IsCorrect() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnItemsTitleWithIndex(4);
        Assert.assertTrue(itemPage.isImageCorrectInItem(4),
                "Items image is not correct.");
    }

    @Test(priority = 56, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatImagePresentInItem6IsCorrect() {

        loginPage.loginWIthValidCredentials();
        inventoryPage.clickOnItemsTitleWithIndex(5);
        Assert.assertTrue(itemPage.isImageCorrectInItem(5),
                "Items image is not correct.");
    }

    @Test(priority = 57, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatTwitterButtonIsPresent() {

        loginPage.loginWIthValidCredentials();
        footerPage.waitUntilTwitterIconIsVisible();
    }

    @Test(priority = 58, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatFacebookButtonIsPresent() {

        loginPage.loginWIthValidCredentials();
        footerPage.waitUntilFacebookIconIsVisible();
    }
}
