package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPage extends BasicPage {
    public HeaderPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public boolean doesBurgerMenuButtonExist() {
        return elementExists(By.id("react-burger-menu-btn"));
    }
    public boolean doesCartIconExist () {
        return elementExists(By.className("shopping_cart_link"));
    }
    public WebElement getBurgerMenuButton() {
        return driver.findElement(By.id("react-burger-menu-btn"));
    }
    public void clickOnBurgerMenuButton() {
        getBurgerMenuButton().click();
    }
    public WebElement getCartIcon() {
        return driver.findElement(By.className("shopping_cart_link"));
    }
    public void clickOnCartIcon() {
        getCartIcon().click();
    }

}
