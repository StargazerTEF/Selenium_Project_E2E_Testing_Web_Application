package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
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
    public boolean checkSpellingOfAllOptionsInBurgerMenu() {
        boolean checkSpelling = true;
        ArrayList<String> namesOfBurgerMenuOptions = new ArrayList<>(Arrays.asList("All Items", "About", "Logout", "Reset App State"));
        int i = 0;
        while (checkSpelling && i < getOptionsFromBurgerMenu().size()) {
            if (!getOptionsFromBurgerMenu().get(i).getText().equals(namesOfBurgerMenuOptions.get(i))) {
                checkSpelling = false;
            }
            i++;
        }
        return checkSpelling;
    }
    public WebElement getAllItemsLink () {
        return driver.findElement(By.id("inventory_sidebar_link"));
    }
    public void clickOnAllItemsLink () {
        getAllItemsLink().click();
    }
    public WebElement getAboutLink () {
        return driver.findElement(By.id("about_sidebar_link"));
    }
    public void clickOnAboutLink () {
        getAboutLink().click();
    }
    public WebElement getLogoutButton () {
        return driver.findElement(By.id("logout_sidebar_link"));
    }
    public void clickOnLogoutButton () {
        getLogoutButton().click();
    }
    public WebElement getResetAppButton () {
        return driver.findElement(By.id("reset_sidebar_link"));
    }
    public void clickOnResetAppButton () {
        getResetAppButton().click();
    }
    public WebElement getExitButton () {
        return driver.findElement(By.id("react-burger-cross-btn"));
    }
    public void waitUntilExitButtonIsVisible () {
        wait
                .withMessage("Exit button should be visible.")
                .until(ExpectedConditions.visibilityOf(getExitButton()));
    }
    public void clickOnExitButton () {
        getExitButton().click();
    }
    public void waitUntilBurgerMenuOptionsBecomeInvisible() {
        wait
                .withMessage("Options from the burger menu should not be visible.")
                .until(ExpectedConditions.invisibilityOfAllElements(getOptionsFromBurgerMenu()));
    }
}
