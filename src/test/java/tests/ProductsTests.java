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
}
