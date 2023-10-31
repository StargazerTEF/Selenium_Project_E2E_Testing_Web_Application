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
}
