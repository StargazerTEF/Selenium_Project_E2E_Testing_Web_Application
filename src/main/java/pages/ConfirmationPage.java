package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    public WebElement getSubHeaderTitle () {
        return driver.findElement(By.cssSelector("span.title"));
    }
    public String getSubHeaderTitleText() {
        return getSubHeaderTitle().getText();
    }
    public WebElement getConfirmationMessageImage() {
        return driver.findElement(By.cssSelector("#checkout_complete_container > img"));
    }
    public void waitUntilConfirmationMessageImageIsVisible() {
        wait
                .withMessage("Confirmation message image should be visible.")
                .until(ExpectedConditions.visibilityOf(getConfirmationMessageImage()));
    }
    public WebElement getConfirmationMessageHeader() {
        return driver.findElement(By.className("complete-header"));
    }
    public String getConfirmationMessageHeaderText() {
        return getConfirmationMessageHeader().getText();
    }
    public WebElement getConfirmationMessageBody() {
        return driver.findElement(By.className("complete-text"));
    }
    public String getConfirmationMessageBodyText() {
        return getConfirmationMessageBody().getText();
    }
}
