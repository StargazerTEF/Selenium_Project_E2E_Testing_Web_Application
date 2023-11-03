package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PaymentPage extends BasicPage{
    public PaymentPage(WebDriver driver, WebDriverWait wait) {
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
    public List<WebElement> getProductsAddedToTheCart () {
        return driver.findElements(By.cssSelector("div.cart_item"));
    }
    public void waitForAddedProductsToBeVisibleOnThePage () {
        wait
                .withMessage("Added products should be visible on the page.")
                .until(ExpectedConditions.visibilityOfAllElements(getProductsAddedToTheCart()));
    }
    public List<WebElement> getTitlesOfProductsAddedToTheCart () {
        return driver.findElements(By.className("inventory_item_name"));
    }
    public void waitForAddedProductsTitlesToBeVisibleOnThePage () {
        wait
                .withMessage("Titles of added products should be visible on the page.")
                .until(ExpectedConditions.visibilityOfAllElements(getTitlesOfProductsAddedToTheCart()));
    }
    public List<WebElement> getDescriptionsOfProductsAddedToTheCart () {
        return driver.findElements(By.className("inventory_item_desc"));
    }
    public void waitForAddedProductsDescriptionsToBeVisibleOnThePage () {
        wait
                .withMessage("Descriptions of added products should be visible on the page.")
                .until(ExpectedConditions.visibilityOfAllElements(getDescriptionsOfProductsAddedToTheCart()));
    }
    public List<WebElement> getPricesOfProductsAddedToTheCart () {
        return driver.findElements(By.className("inventory_item_price"));
    }
    public void waitForAddedProductsPricesToBeVisibleOnThePage () {
        wait
                .withMessage("Prices of added products should be visible on the page.")
                .until(ExpectedConditions.visibilityOfAllElements(getPricesOfProductsAddedToTheCart()));
    }
    public List<WebElement> getQuantitiesOfProductsAddedToTheCart() {
        return driver.findElements(By.cssSelector(".cart_item .cart_quantity"));
    }
    public void waitForAddedProductsQuantitiesToBeVisibleOnThePage() {
        wait
                .withMessage("Quantities of added products should be visible on the page.")
                .until(ExpectedConditions.visibilityOfAllElements(getQuantitiesOfProductsAddedToTheCart()));
    }
    public WebElement getTitleOfProductAddedToTheCartWithIndex(int indexOfProduct) {
        return getTitlesOfProductsAddedToTheCart().get(indexOfProduct);
    }
    public void waitUntilItemsTitleIsClickable (int indexOfProduct) {
        wait
                .withMessage("Item's title should be clickable.")
                .until(ExpectedConditions.elementToBeClickable(getTitleOfProductAddedToTheCartWithIndex(indexOfProduct)));
    }
    public void clickOnItemsTitle (int indexOfProduct) {
        getTitleOfProductAddedToTheCartWithIndex(indexOfProduct).click();
    }
    public WebElement getPaymentInformation () {
        return driver.findElement(By.cssSelector(".summary_info > div:nth-child(1)"));
    }
    public String getPaymentInformationText () {
        return getPaymentInformation().getText();
    }
    public WebElement getShippingInformation () {
        return driver.findElement(By.cssSelector(".summary_info > div:nth-child(3)"));
    }
    public String getShippingInformationText () {
        return getShippingInformation().getText();
    }
}
