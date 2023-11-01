package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemPage extends BasicPage {
    public ItemPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getItemsTitle() {
        return driver.findElement(By.className("inventory_details_name"));
    }
    public void waitUntilItemsTitleIsVisible() {
        wait
                .withMessage("Item's title should be visible.")
                .until(ExpectedConditions.visibilityOf(getItemsTitle()));
    }
    public WebElement getItemsDescription() {
        return driver.findElement(By.cssSelector("div.inventory_details_desc.large_size"));
    }
    public void waitUntilItemsDescriptionIsVisible() {
        wait
                .withMessage("Item's description should be visible.")
                .until(ExpectedConditions.visibilityOf(getItemsDescription()));
    }
    public WebElement getItemsPrice() {
        return driver.findElement(By.className("inventory_details_price"));
    }
    public void waitUntilItemsPriceIsVisible() {
        wait
                .withMessage("Item's price should be visible.")
                .until(ExpectedConditions.visibilityOf(getItemsPrice()));
    }
    public WebElement getItemsAddToCartButton() {
        return driver.findElement(By.className("btn_inventory"));
    }
    public void waitUntilItemsAddToCartButtonIsVisible() {
        wait
                .withMessage("Item's add to cart button should be visible.")
                .until(ExpectedConditions.visibilityOf(getItemsAddToCartButton()));
    }
    public void clickOnItemsAddToCartButton() {
        getItemsAddToCartButton().click();
    }
    public void waitUntilItemsButtonTextBecomesRemove() {
        wait
                .withMessage("Item's button text should be 'Remove'.")
                .until(ExpectedConditions.textToBePresentInElement(getItemsAddToCartButton(), "Remove"));
    }
    public void clickOnItemsRemoveButton() {
        getItemsAddToCartButton().click();
    }
}
