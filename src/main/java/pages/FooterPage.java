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
    public WebElement getFacebookIcon () {
        return driver.findElement(By.cssSelector(".social_facebook a"));
    }
    public void waitUntilFacebookIconIsVisible () {
        wait
                .withMessage("Facebook icon should be visible.")
                .until(ExpectedConditions.visibilityOf(getFacebookIcon()));
    }
    public WebElement getLinkedInIcon () {
        return driver.findElement(By.cssSelector(".social_linkedin a"));
    }
    public void waitUntilLinkedInIconIsVisible () {
        wait
                .withMessage("LinkedIn icon in the footer should be visible.")
                .until(ExpectedConditions.visibilityOf(getLinkedInIcon()));
    }
}
