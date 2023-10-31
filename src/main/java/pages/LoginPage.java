package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getHeader() {
        return driver.findElement(By.className("login_logo"));
    }
    public String getHeaderText() {
        return getHeader().getText();
    }
    public boolean doesUsernameFieldExist() {
        return elementExists(By.id("user-name"));
    }
    public boolean doesPasswordFieldExist() {
        return elementExists(By.id("password"));
    }
    public boolean doesLoginButtonExist () {
        return elementExists(By.id("login-button"));
    }
    public WebElement getUsernameField() {
        return driver.findElement(By.id("user-name"));
    }
    public void clickOnUsernameField() {
        getUsernameField().click();
    }
    public void fillInUsernameField(String userName) {
        getUsernameField().clear();
        getUsernameField().sendKeys(userName);
    }
    public WebElement getPasswordField () {
        return driver.findElement(By.id("password"));
    }
    public void clickOnPasswordField() {
        getPasswordField().click();
    }
    public void fillInPasswordField(String password) {
        getPasswordField().clear();
        getPasswordField().sendKeys(password);
    }
}
