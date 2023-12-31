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

    @Test(priority = 12, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTheLabelOfLoginButton() {

        Assert.assertEquals(loginPage.getLoginButtonLabel(), "Login",
                "Label of login button should be 'Login'.");
    }

    @Test(priority = 13, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyThatTheLoginButtonIsWorking() {

        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.fillInUsernameField(username);
        loginPage.fillInPasswordField(password);
        loginPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "inventory.html",
                "User should be redirected to the products page.");
    }

    @Test(priority = 14, retryAnalyzer = RetryAnalyzer.class)
    public void LoginWithCorrectUsernameAndPassword() {

        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.fillInUsernameField(username);
        loginPage.fillInPasswordField(password);
        loginPage.clickOnLoginButton();
        Assert.assertFalse(loginPage.doesUsernameFieldExistWhenUserIsLoggedIn(),
                "Username field shouldn't be present.");
    }

    @Test(priority = 15, retryAnalyzer = RetryAnalyzer.class)
    public void LoginWithCorrectUsernameAndIncorrectPassword() {

        String username = "standard_user";
        String password = "secret_sauce123";

        loginPage.fillInUsernameField(username);
        loginPage.fillInPasswordField(password);
        loginPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl,
                "User should fail to login.");
    }

    @Test(priority = 16, retryAnalyzer = RetryAnalyzer.class)
    public void LoginWithIncorrectUsernameAndCorrectPassword() {

        String username = "standard_user123";
        String password = "secret_sauce";

        loginPage.fillInUsernameField(username);
        loginPage.fillInPasswordField(password);
        loginPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl,
                "User should fail to login.");
    }

    @Test(priority = 17, retryAnalyzer = RetryAnalyzer.class)
    public void LoginWithIncorrectUsernameAndPassword() {

        String username = "standard_user123";
        String password = "secret_sauce123";

        loginPage.fillInUsernameField(username);
        loginPage.fillInPasswordField(password);
        loginPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl,
                "User should fail to login.");
    }

    @Test(priority = 18, retryAnalyzer = RetryAnalyzer.class)
    public void LoginWithBlankUsernameAndPassword() {

        String username = "";
        String password = "";

        loginPage.fillInUsernameField(username);
        loginPage.fillInPasswordField(password);
        loginPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl,
                "User should fail to login.");
    }

    @Test(priority = 19, retryAnalyzer = RetryAnalyzer.class)
    public void LoginWithBlankUsernameAndCorrectPassword() {

        String username = "";
        String password = "secret_sauce";

        loginPage.fillInUsernameField(username);
        loginPage.fillInPasswordField(password);
        loginPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl,
                "User should fail to login.");
    }

    @Test(priority = 20, retryAnalyzer = RetryAnalyzer.class)
    public void LoginWithBlankUsernameAndIncorrectPassword() {

        String username = "";
        String password = "secret_sauce123";

        loginPage.fillInUsernameField(username);
        loginPage.fillInPasswordField(password);
        loginPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl,
                "User should fail to login.");
    }

    @Test(priority = 21, retryAnalyzer = RetryAnalyzer.class)
    public void LoginWithCorrectUsernameAndBlankPassword() {

        String username = "standard_user";
        String password = "";

        loginPage.fillInUsernameField(username);
        loginPage.fillInPasswordField(password);
        loginPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl,
                "User should fail to login.");
    }

    @Test(priority = 22, retryAnalyzer = RetryAnalyzer.class)
    public void LoginWithIncorrectUsernameAndBlankPassword() {

        String username = "standard_user123";
        String password = "";

        loginPage.fillInUsernameField(username);
        loginPage.fillInPasswordField(password);
        loginPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl,
                "User should fail to login.");
    }

    @Test(priority = 23, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTheErrorMessageWhenUsernameAndPasswordDoNotMatch() {

        String username = "standard_user123";
        String password = "secret_sauce123";

        loginPage.fillInUsernameField(username);
        loginPage.fillInPasswordField(password);
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getLoginErrorMessageText(),
                "Epic sadface: Username and password do not match any user in this service",
                "Error message should be 'Epic sadface: Username and password do not match any user in this service'.");
    }

    @Test(priority = 24, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTheErrorMessageForBlankUsernameField() {

        String username = "";
        String password = "secret_sauce";

        loginPage.fillInUsernameField(username);
        loginPage.fillInPasswordField(password);
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getLoginErrorMessageText(),
                "Epic sadface: Username is required",
                "Error message should be 'Epic sadface: Username is required'.");
    }
    @Test(priority = 25, retryAnalyzer = RetryAnalyzer.class)
    public void VerifyTheErrorMessageForBlankPasswordField() {

        String username = "standard_user";
        String password = "";

        loginPage.fillInUsernameField(username);
        loginPage.fillInPasswordField(password);
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getLoginErrorMessageText(),
                "Epic sadface: Password is required",
                "Error message should be 'Epic sadface: Password is required'.");
    }
}
