package com.coherentsolutions.training.automation.java.web.urnezaite;

import com.coherentsolutions.training.automation.java.web.urnezaite.util.Log;
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
    WebElement newWishlistNameInput;

    @FindBy(id = "submitWishlist")
    WebElement saveWishlist;


    @FindBy(css = "table tr")
    List<WebElement> wishlistLists;

    @FindBy(css = "ul.wlp_bought_list>li img")
    List<WebElement> wishlistItems;

    @FindBy(css = "td.wishlist_delete>a.icon")
    WebElement deleteWishlistIcon;

    private final By deleteWishlistIconSelector = By.cssSelector("td.wishlist_delete>a.icon");

    private final String DEFAULT_WISHLIST_NAME = "My wishlist";

    List<String> namesOfWishListItems = new ArrayList<>();

    public boolean wishlistEmpty;

    public WishlistPage(WebDriver driver) {
        super(driver);
        wishlistEmpty = wishlistLists.size() == 0;
    }

    public MainPage goToHomePage() {
        homeButton.click();
        return new MainPage(driver);
    }

    public CartPage goToCartPage() {
        cartButton.click();
        return new CartPage(driver);
    }

    public boolean isWishlistEmpty() {
        return wishlistEmpty;
    }

    public void removeAllLists() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        int numberOfLists = wishlistLists.size();
        for (int i = numberOfLists; i > 0; i--) {
            deleteWishlistIcon.click();
            wait.until(ExpectedConditions.alertIsPresent()).accept();
            wait.until(ExpectedConditions.numberOfElementsToBeLessThan(deleteWishlistIconSelector, i));
        }
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

    public boolean checkIfItemWasAddedToWishlist(String itemsName) {
        if (!wishlistEmpty) {
            wishlistItems.forEach(item -> namesOfWishListItems.add(item.getAttribute("alt")));
            Log.info("items in selected list: " + namesOfWishListItems);
        }
        return namesOfWishListItems.contains(itemsName);
    }
}