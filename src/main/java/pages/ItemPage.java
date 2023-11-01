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
                .withMessage("Items title should be visible.")
                .until(ExpectedConditions.visibilityOf(getItemsTitle()));
    }
}
