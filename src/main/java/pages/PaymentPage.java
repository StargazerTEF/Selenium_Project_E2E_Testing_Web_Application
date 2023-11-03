package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
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
    public List<String> getPricesWithout$OfItemsAddedToTheCart () {
        List<String> pricesWithout$ = new ArrayList<>();
        for (int i = 0; i < getPricesOfProductsAddedToTheCart().size(); i++) {
            String priceWithout$ = getPricesOfProductsAddedToTheCart().get(i).getText().replace("$", "");
            pricesWithout$.add(priceWithout$);
        }
        return pricesWithout$;
    }
    public List<Double> getPricesDoubleOfItemsAddedToTheCart() {
        List<Double> pricesDouble = new ArrayList<>();
        for (int i = 0; i < getPricesWithout$OfItemsAddedToTheCart().size(); i++) {
            double priceDouble = Double.parseDouble(getPricesWithout$OfItemsAddedToTheCart().get(i));
            pricesDouble.add(priceDouble);
        }
        return pricesDouble;
    }
    public double getTotalPriceOfItemsAddedToTheCart() {
        double sum = 0;
        for (int i = 0; i < getPricesDoubleOfItemsAddedToTheCart().size(); i++) {
            sum += getPricesDoubleOfItemsAddedToTheCart().get(i);
        }
        return sum;
    }
    public WebElement getSumOfAllItemsAddedToTheCart() {
        return driver.findElement(By.className("summary_subtotal_label"));
    }
    public String getSumOfAllItemsAddedToTheCartString() {
        return getSumOfAllItemsAddedToTheCart().getText().replace("Item total: $", "");
    }
    public double getTotalSumOfAllItemsAddedToTheCart() {
        return Double.parseDouble(getSumOfAllItemsAddedToTheCartString());
    }
    public WebElement getTax() {
        return driver.findElement(By.className("summary_tax_label"));
    }
    public String getTaxString() {
        return getTax().getText().replace("Tax: $", "");
    }
    public double getTaxNumber() {
        return Double.parseDouble(getTaxString());
    }
    public double getTotalPriceOfAddedItemsWithTax() {
        return getTotalPriceOfItemsAddedToTheCart() + getTaxNumber();
    }
    public WebElement getTotalSumOfAddedItemsWithTax() {
        return driver.findElement(By.className("summary_total_label"));
    }
    public String getTotalSumOfAddedItemsWithTaxString() {
        return getTotalSumOfAddedItemsWithTax().getText().replace("Total: $", "");
    }
    public double getTotalSumOfAddedItemsWithTaxNumber() {
        return Double.parseDouble(getTotalSumOfAddedItemsWithTaxString());
    }
    public WebElement getCancelButton() {
        return driver.findElement(By.id("cancel"));
    }
    public void waitUntilCancelButtonIsVisible() {
        wait
                .withMessage("Cancel button should be visible on the page.")
                .until(ExpectedConditions.visibilityOf(getCancelButton()));
    }
}
