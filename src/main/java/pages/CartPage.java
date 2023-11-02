package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage extends BasicPage {
    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void waitForCartPageToContainAddedProducts () {
        wait
                .withMessage("Cart page should contain added products.")
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("cart_item"), 0));
    }
    public List<WebElement> getTitlesOfItemsAddedToTheCart() {
        return driver.findElements(By.className("inventory_item_name"));
    }
    public WebElement getTitleOfItemAddedToTheCartWithIndex(int itemsIndex) {
        return getTitlesOfItemsAddedToTheCart().get(itemsIndex);
    }
    public String getTitleTextOfTheItemAddedToTheCartWithIndex(int itemsIndex) {
        return getTitleOfItemAddedToTheCartWithIndex(0).getText();
    }
    public WebElement getHeaderTitle () {
        return driver.findElement(By.className("app_logo"));
    }
    public String getHeaderTitleText () {
        return getHeaderTitle().getText();
    }
    public WebElement getSubHeaderTitle () {
        return driver.findElement(By.cssSelector("span.title"));
    }
    public String getSubHeaderTitleText () {
        return getSubHeaderTitle().getText();
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
}
