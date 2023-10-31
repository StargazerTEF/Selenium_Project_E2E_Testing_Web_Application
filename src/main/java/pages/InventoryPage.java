package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    public WebElement getSubTitle() {
        return driver.findElement(By.cssSelector("span.title"));
    }
    public String getSubTitleText() {
        return getSubTitle().getText();
    }
    public WebElement getFilterButton() {
        return driver.findElement(By.cssSelector("span.select_container"));
    }
    public void waitUntilFilterButtonIsVisible() {
        wait
                .withMessage("Filter button should be visible.")
                .until(ExpectedConditions.visibilityOf(getFilterButton()));
    }
    public void clickOnFilterButton() {
        getFilterButton().click();
    }
    public List<WebElement> getFilterMenuOptions() {
        return driver.findElements(By.cssSelector(".product_sort_container > option"));
    }
    public void waitUntilFilterMenuOptionsAreVisible() {
        wait
                .withMessage("Filter menu should be visible.")
                .until(ExpectedConditions.visibilityOfAllElements(getFilterMenuOptions()));
    }
    public WebElement getAscendingNamesOptionFromFilterMenu() {
        return driver.findElement(By.cssSelector("[value='az']"));
    }
    public void clickOnAscendingNamesOptionFromFilterMenu() {
        getAscendingNamesOptionFromFilterMenu().click();
    }
    public List<WebElement> getProductNames() {
        return driver.findElements(By.className("inventory_item_name"));
    }
    public boolean isAscendingNamesFilterWorking() {
        boolean isAscendingNamesFilterWorking = true;
        int x = 0;
        int i = 1;
        while (isAscendingNamesFilterWorking && i < getProductNames().size()) {
            String previous = getProductNames().get(x).getText();
            if (getProductNames().get(i).getText().compareTo(previous) < 0) {
                isAscendingNamesFilterWorking = false;
            }
            i++;
            x++;
        }
        return isAscendingNamesFilterWorking;
    }
}
