package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasicPage{
    public CheckoutPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getHeader() {
        return driver.findElement(By.className("app_logo"));
    }
    public String getHeaderText() {
        return getHeader().getText();
    }
    public WebElement getSubHeaderTitle() {
        return driver.findElement(By.cssSelector("span.title"));
    }

    public String getSubHeaderTitleText() {
        return getSubHeaderTitle().getText();
    }
    public WebElement getFirstNameField() {
        return driver.findElement(By.id("first-name"));
    }
    public void waitUntilFirstNameFieldIsVisible () {
        wait
                .withMessage("First name field should be visible on the page.")
                .until(ExpectedConditions.visibilityOf(getFirstNameField()));
    }
    public WebElement getLastNameField() {
        return driver.findElement(By.id("last-name"));
    }
    public void waitUntilLastNameFieldIsVisible () {
        wait
                .withMessage("Last name field should be visible on the page.")
                .until(ExpectedConditions.visibilityOf(getLastNameField()));
    }
}
