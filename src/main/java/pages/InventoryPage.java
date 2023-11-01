package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InventoryPage extends BasicPage {
    public InventoryPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getHeader() {
        return driver.findElement(By.className("app_logo"));
    }
    public String getHeaderText() {
        return getHeader().getText();
    }
    public List<WebElement> getItemsAddToCartButtons() {
        return driver.findElements(By.className("btn_inventory"));
    }
    public WebElement getItemsAddToCardButtonWithIndex(int itemsIndex) {
        return getItemsAddToCartButtons().get(itemsIndex);
    }
    public void clickOnAddToCartButtonWithIndex(int itemsIndex) {
        getItemsAddToCardButtonWithIndex(itemsIndex).click();
    }
    public WebElement getSubTitle() {
        return driver.findElement(By.cssSelector("span.title"));
    }
    public String getSubTitleText() {
        return getSubTitle().getText();
    }
    public WebElement getFilterButton() {
        return driver.findElement(By.cssSelector("span.select_container"));
    }
    public void waitUntilFilterButtonIsVisible() {
        wait
                .withMessage("Filter button should be visible.")
                .until(ExpectedConditions.visibilityOf(getFilterButton()));
    }
    public void clickOnFilterButton() {
        getFilterButton().click();
    }
    public List<WebElement> getFilterMenuOptions() {
        return driver.findElements(By.cssSelector(".product_sort_container > option"));
    }
    public void waitUntilFilterMenuOptionsAreVisible() {
        wait
                .withMessage("Filter menu should be visible.")
                .until(ExpectedConditions.visibilityOfAllElements(getFilterMenuOptions()));
    }
    public WebElement getAscendingNamesOptionFromFilterMenu() {
        return driver.findElement(By.cssSelector("[value='az']"));
    }
    public void clickOnAscendingNamesOptionFromFilterMenu() {
        getAscendingNamesOptionFromFilterMenu().click();
    }
    public List<WebElement> getProductNames() {
        return driver.findElements(By.className("inventory_item_name"));
    }
    public boolean isAscendingNamesFilterWorking() {
        boolean isAscendingNamesFilterWorking = true;
        int x = 0;
        int i = 1;
        while (isAscendingNamesFilterWorking && i < getProductNames().size()) {
            String previous = getProductNames().get(x).getText();
            if (getProductNames().get(i).getText().compareTo(previous) < 0) {
                isAscendingNamesFilterWorking = false;
            }
            i++;
            x++;
        }
        return isAscendingNamesFilterWorking;
    }
    public WebElement getDescendingNamesOptionFromFilterMenu() {
        return driver.findElement(By.cssSelector("[value='za']"));
    }
    public void clickOnDescendingNamesOptionFromFilterMenu() {
        getDescendingNamesOptionFromFilterMenu().click();
    }
    public boolean isDescendingNamesFilterWorking() {
        boolean isDescendingNamesFilterWorking = true;
        int x = 0;
        int i = 1;
        while (isDescendingNamesFilterWorking && i < getProductNames().size()) {
            String previous = getProductNames().get(x).getText();
            if (getProductNames().get(i).getText().compareTo(previous) > 0) {
                isDescendingNamesFilterWorking = false;
            }
            i++;
            x++;
        }
        return isDescendingNamesFilterWorking;
    }
    public WebElement getAscendingPricesOptionFromFilterMenu() {
        return driver.findElement(By.cssSelector("[value='lohi']"));
    }
    public void clickOnAscendingPricesOptionFromFilterMenu() {
        getAscendingPricesOptionFromFilterMenu().click();
    }
    public List<WebElement> getProductPrices() {
        return driver.findElements(By.className("inventory_item_price"));
    }
    public List<String> getProductPricesWithout$() {
        List<String> productPricesWithout$ = new ArrayList<>();
        for (int i = 0; i < getProductPrices().size(); i++) {
            String productPrices = getProductPrices().get(i).getText().replace("$", "");
            productPricesWithout$.add(productPrices);
        }
        return productPricesWithout$;
    }
    public List<Double> getProductPricesDouble() {
        List<Double> productPricesDouble = new ArrayList<>();
        for (int i = 0; i < getProductPricesWithout$().size(); i++) {
            Double productPrices = Double.parseDouble(getProductPricesWithout$().get(i));
            productPricesDouble.add(productPrices);
        }
        return productPricesDouble;
    }
    public boolean isAscendingPricesFilterWorking() {
        boolean isAscendingPricesFilterWorking = true;
        int x = 0;
        int i = 1;
        while (isAscendingPricesFilterWorking && i < getProductNames().size()) {
            Double previous = getProductPricesDouble().get(x);
            if (getProductPricesDouble().get(i) < previous) {
                isAscendingPricesFilterWorking = false;
            }
            i++;
            x++;
        }
        return isAscendingPricesFilterWorking;
    }
    public WebElement getDescendingPricesOptionFromFilterMenu() {
        return driver.findElement(By.cssSelector("[value='hilo']"));
    }
    public void clickOnDescendingPricesOptionFromFilterMenu() {
        getDescendingPricesOptionFromFilterMenu().click();
    }
    public boolean isDescendingPricesFilterWorking() {
        boolean isDescendingPricesFilterWorking = true;
        int x = 0;
        int i = 1;
        while (isDescendingPricesFilterWorking && i < getProductNames().size()) {
            Double previous = getProductPricesDouble().get(x);
            if (getProductPricesDouble().get(i) > previous) {
                isDescendingPricesFilterWorking = false;
            }
            i++;
            x++;
        }
        return isDescendingPricesFilterWorking;
    }
    public boolean checkSpellingOfAllOptionsInFilterMenu() {
        boolean checkSpelling = true;
        ArrayList<String> namesOfFilterMenuOptions = new ArrayList<>(Arrays.asList("Name (A to Z)", "Name (Z to A)", "Price (low to high)", "Price (high to low)"));
        int i = 0;
        while (checkSpelling && i < getFilterMenuOptions().size()) {
            if (!getFilterMenuOptions().get(i).getText().equals(namesOfFilterMenuOptions.get(i))) {
                checkSpelling = false;
            }
            i++;
        }
        return checkSpelling;
    }
    public int getNumberOfFilterMenuOptions() {
        return getFilterMenuOptions().size();
    }
    public List<WebElement> getItemCards() {
        return driver.findElements(By.cssSelector("div.inventory_item"));
    }
    public void waitUntilItemCardsAreVisible() {
        wait
                .withMessage("Item cards should be visible.")
                .until(ExpectedConditions.visibilityOfAllElements(getItemCards()));
    }
    public int getNumberOfItemCards() {
        return getItemCards().size();
    }
    public List<WebElement> getItemsTitles() {
        return driver.findElements(By.className("inventory_item_name"));
    }
    public void waitUntilItemsTitlesAreVisible() {
        wait
                .withMessage("Items titles should be visible.")
                .until(ExpectedConditions.visibilityOfAllElements(getItemsTitles()));
    }
    public List<WebElement> getItemsDescriptions() {
        return driver.findElements(By.className("inventory_item_desc"));
    }
    public void waitUntilItemsDescriptionsAreVisible() {
        wait
                .withMessage("Items descriptions should be visible.")
                .until(ExpectedConditions.visibilityOfAllElements(getItemsDescriptions()));
    }
    public List<WebElement> getItemsPrices() {
        return driver.findElements(By.className("inventory_item_price"));
    }
    public void waitUntilItemsPricesAreVisible() {
        wait
                .withMessage("Items prices should be visible.")
                .until(ExpectedConditions.visibilityOfAllElements(getItemsPrices()));
    }
    public List<WebElement> getItemsImages() {
        return driver.findElements(By.cssSelector("img.inventory_item_img"));
    }
    public void waitUntilItemsImagesAreVisible() {
        wait
                .withMessage("Items images should be visible.")
                .until(ExpectedConditions.visibilityOfAllElements(getItemsImages()));
    }
    public void waitUntilItemsAddToCartButtonsAreVisible() {
        wait
                .withMessage("Items add to cart buttons should be visible.")
                .until(ExpectedConditions.visibilityOfAllElements(getItemsAddToCartButtons()));
    }
    public void waitUntilItemsTitleIsClickableWithIndex(int itemsIndex) {
        wait
                .withMessage("Item's title with index " + itemsIndex + " should be clickable.")
                .until(ExpectedConditions.elementToBeClickable(getItemsTitles().get(itemsIndex)));
    }
    public void clickOnItemsTitleWithIndex(int itemsIndex) {
        getItemsTitles().get(itemsIndex).click();
    }
    public void waitUntilTextInItemsButtonBecomesRemove(int itemsIndex) {
        wait
                .withMessage("Items text in the button field with index " + itemsIndex + " should be 'Remove'.")
                .until(ExpectedConditions.textToBePresentInElement(getItemsAddToCardButtonWithIndex(itemsIndex), "Remove"));
    }
    public void clickOnRemoveButtonWithIndex(int itemsIndex) {
        getItemsAddToCartButtons().get(itemsIndex).click();
    }
}
