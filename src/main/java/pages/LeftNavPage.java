package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LeftNavPage extends BasicPage {
    public LeftNavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public List<WebElement> getOptionsFromBurgerMenu() {
        return driver.findElements(By.cssSelector(".bm-item-list a"));
    }
    public void waitUntilBurgerMenuOptionsBecomeVisible() {
        wait
                .withMessage("Options from the burger menu should be visible.")
                .until(ExpectedConditions.visibilityOfAllElements(getOptionsFromBurgerMenu()));
    }
    public int getNumberOfBurgerMenuOptions () {
        return getOptionsFromBurgerMenu().size();
    }
}
