package com.coherentsolutions.training.automation.java.web.urnezaite;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WishlistPage extends BasePage {

    @FindBy(css = "a.home")
    private WebElement homeButton;

    @FindBy(id = "name")
    private WebElement newWishlistNameInput;

    @FindBy(id = "submitWishlist")
    private WebElement saveWishlist;

    @FindBy(css = "table tr")
    private List<WebElement> wishlists;

    @FindBy(css = "ul.wlp_bought_list>li img")
    private List<WebElement> wishlistItems;

    @FindBy(css = "td.wishlist_delete>a.icon")
    private List<WebElement> deleteWishlistIcons;

    private final String DEFAULT_WISHLIST_NAME = "My wishlist";

    private static final Logger logger = LogManager.getLogger(WishlistPage.class);

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    public HomePage goToHomePage() {
        homeButton.click();
        return new HomePage(driver);
    }

    public CartPage goToCartPage() {
        cartButton.click();
        return new CartPage(driver);
    }

    public boolean isWishlistEmpty() {
        return wishlists.size() == 0;
    }

    public void removeAllLists() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        deleteWishlistIcons.forEach(element -> {
            element.click();
            wait.until(ExpectedConditions.alertIsPresent()).accept();
        });
    }

    public void createNewWishlist(String wishlistName) {
        newWishlistNameInput.sendKeys(wishlistName);
        saveWishlist.click();
    }

    public void showCreatedList(String wishlistName) {
        driver.findElement(By.xpath(String.format("//a[contains(text(), '%s')]", wishlistName))).click();
    }

    public void showList() {
        driver.findElement(By.xpath(String.format("//a[contains(text(), '%s')]", DEFAULT_WISHLIST_NAME))).click();
    }

    public boolean isItemInWishlist(String itemsName) {
        List<String> namesOfWishListItems = new ArrayList<>();
        wishlistItems.forEach(item -> namesOfWishListItems.add(item.getAttribute("alt")));
        logger.info("items in selected list: " + namesOfWishListItems);
        return namesOfWishListItems.contains(itemsName);
    }
}