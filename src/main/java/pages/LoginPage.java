package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getHeader () {
        return driver.findElement(By.className("login_logo"));
    }
    public String getHeaderText () {
        return getHeader().getText();
    }
    public boolean doesUsernameFieldExist() {
        return elementExists(By.id("user-name"));
    }
    public boolean doesPasswordFieldExist() {
        return elementExists(By.id("password"));
    }
}
