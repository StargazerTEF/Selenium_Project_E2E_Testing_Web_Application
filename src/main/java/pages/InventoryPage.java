package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class InventoryPage extends BasicPage {
    public InventoryPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getHeader() {
        return driver.findElement(By.className("app_logo"));
    }
    public String getHeaderText() {
        return getHeader().getText();
    }
    public List<WebElement> getItemsAddToCartButtons() {
        return driver.findElements(By.className("btn_inventory"));
    }
    public WebElement getItemsAddToCardButtonWithIndex(int itemsIndex) {
        return getItemsAddToCartButtons().get(itemsIndex);
    }
    public void clickOnAddToCartButtonWithIndex(int itemsIndex) {
        getItemsAddToCardButtonWithIndex(itemsIndex).click();
    }
}
