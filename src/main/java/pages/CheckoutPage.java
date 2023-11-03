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
    public WebElement getZipCodeField() {
        return driver.findElement(By.id("postal-code"));
    }
    public void waitUntilZipCodeFieldIsVisible () {
        wait
                .withMessage("Zip code field should be visible on the page.")
                .until(ExpectedConditions.visibilityOf(getZipCodeField()));
    }
    public void fillInFirstNameField (String firstName) {
        getFirstNameField().clear();
        getFirstNameField().sendKeys(firstName);
    }
    public void fillInLastNameField (String lastName) {
        getLastNameField().clear();
        getLastNameField().sendKeys(lastName);
    }
    public void fillInZipCodeField (String zipCode) {
        getZipCodeField().clear();
        getZipCodeField().sendKeys(zipCode);
    }
    public WebElement getContinueButton() {
        return driver.findElement(By.id("continue"));
    }
    public void clickOnContinueButton() {
        getContinueButton().click();
    }
    public WebElement getErrorMessage() {
        return driver.findElement(By.cssSelector("div.error-message-container > h3"));
    }
    public String getErrorMessageText() {
        return getErrorMessage().getText();
    }
    public WebElement getCancelButton() {
        return driver.findElement(By.id("cancel"));
    }
    public void waitUntilCancelButtonIsVisible () {
        wait
                .withMessage("Cancel button should be visible on the page.")
                .until(ExpectedConditions.visibilityOf(getCancelButton()));
    }
    public void clickOnCancelButton() {
        getCancelButton().click();
    }
    public void waitUntilContinueButtonIsVisible () {
        wait
                .withMessage("Continue button should be visible on the page.")
                .until(ExpectedConditions.visibilityOf(getContinueButton()));
    }
    public void fillOutCheckoutFormWithValidInputs() {
        fillInFirstNameField("Aki");
        fillInLastNameField("Akic");
        fillInZipCodeField("11000");
    }
}
