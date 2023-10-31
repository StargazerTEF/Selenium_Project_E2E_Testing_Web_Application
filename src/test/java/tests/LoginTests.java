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
}
