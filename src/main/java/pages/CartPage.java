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
}
