package tests;

import helper.Helper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;

import java.io.IOException;
import java.time.Duration;

public abstract class BasicTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl = "https://www.saucedemo.com/";
    protected JavascriptExecutor js;
    protected LoginPage loginPage;
    protected InventoryPage inventoryPage;
    protected HeaderPage headerPage;
    protected LeftNavPage leftNavPage;
    protected CartPage cartPage;
    protected ItemPage itemPage;
    protected FooterPage footerPage;
    protected CheckoutPage checkoutPage;
    protected PaymentPage paymentPage;
    protected ConfirmationPage confirmationPage;

    @Parameters ("browser")
    @BeforeClass
    public void setup(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
        loginPage = new LoginPage(driver, wait);
        inventoryPage = new InventoryPage(driver, wait);
        headerPage = new HeaderPage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        leftNavPage = new LeftNavPage(driver, wait);
        cartPage = new CartPage(driver, wait);
        itemPage = new ItemPage(driver, wait);
        footerPage = new FooterPage(driver, wait);
        checkoutPage = new CheckoutPage(driver, wait);
        paymentPage = new PaymentPage(driver, wait);
        confirmationPage = new ConfirmationPage(driver, wait);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().deleteAllCookies();
        driver.navigate().to(baseUrl);
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) throws IOException {
        js.executeScript("window.localStorage.clear();");
        if (testResult.getStatus() == ITestResult.FAILURE) {
            Helper.takeScreenshotWithDateTimeFormat(driver, testResult.getName());
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

