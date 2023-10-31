package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPage extends BasicPage {
    public HeaderPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public boolean doesBurgerMenuButtonExist() {
        return elementExists(By.id("react-burger-menu-btn"));
    }
}
