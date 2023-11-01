package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FooterPage extends BasicPage {
    public FooterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getTwitterIcon () {
        return driver.findElement(By.cssSelector(".social_twitter a"));
    }
    public void waitUntilTwitterIconIsVisible () {
        wait
                .withMessage("Twitter icon should be visible.")
                .until(ExpectedConditions.visibilityOf(getTwitterIcon()));
    }
}
