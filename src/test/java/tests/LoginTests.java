package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class LoginTests extends BasicTest {

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyUrl() {

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl,
                "Current url should be " + baseUrl);

    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThePageTitle() {

        Assert.assertEquals(driver.getTitle(),
                "Swag Labs",
                "Title of the page should be 'Swag Labs'.");
    }

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTheTitleInHeader() {

        Assert.assertEquals(loginPage.getHeaderText(),
                "Swag Labs",
                "Title in header should be 'Swag Labs'.");
    }

    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatUsernameFieldIsPresent() {

        Assert.assertTrue(loginPage.doesUsernameFieldExist(),
                "Username field should be present.");
    }

    @Test(priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatPasswordFieldIsPresent() {

        Assert.assertTrue(loginPage.doesPasswordFieldExist(),
                "Password field should be present.");
    }

    @Test(priority = 6, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatLoginButtonIsPresent() {

        Assert.assertTrue(loginPage.doesLoginButtonExist(),
                "Login button should be present.");
    }

    @Test(priority = 7, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatUsernameFieldIsEnabled() {

        loginPage.clickOnUsernameField();
        loginPage.fillInUsernameField("abc");
        Assert.assertTrue(loginPage.getUsernameField().isEnabled(),
                "Username field should be enabled.");
    }

    @Test(priority = 8, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatPasswordFieldIsEnabled() {

        loginPage.clickOnPasswordField();
        loginPage.fillInPasswordField("123");
        Assert.assertTrue(loginPage.getPasswordField().isEnabled(),
                "Password field should be enabled.");
    }

    @Test(priority = 9, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatLoginButtonIsEnabled() {

        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.getLoginButton().isEnabled(),
                "Login button should be enabled.");
    }

    @Test(priority = 10, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTheLabelOfUsernameField() {

        Assert.assertEquals(loginPage.getUsernameFieldLabel(), "Username",
                "Label of username field should be 'Username'.");
    }
    @Test(priority = 11, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTheLabelOfPasswordField() {

        Assert.assertEquals(loginPage.getPasswordFieldLabel(), "Password",
                "Label of password field should be 'Password'.");
    }
}
