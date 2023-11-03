package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationPage extends BasicPage {
    public ConfirmationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getHeaderTitle () {
        return driver.findElement(By.className("app_logo"));
    }
    public String getHeaderTitleText() {
        return getHeaderTitle().getText();
    }
}