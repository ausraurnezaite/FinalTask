package com.coherensolutions.training.automation.java.web.urnezaite;

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

    @FindBy(id = "mywishlist")
    private WebElement wishlistArea;

    String defaultWishlistName = "My wishlist";

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    public MainPage goToHomePage() {
        homeButton.click();
        return new MainPage(driver);
    }

    public CartPage goToCartPage() {
        cartButton.click();
        return new CartPage(driver);
    }

    public LogInPage logout() {
        logOutButton.click();
        return new LogInPage(driver);
    }

    public boolean isWishlistEmpty() {
        List<WebElement> wishListElements = wishlistArea.findElements(By.cssSelector("table"));
        return wishListElements.size() == 0;
    }

    public void removeAllLists() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        int numberOfLists = driver.findElements(By.cssSelector("td.wishlist_delete>a.icon")).size();
        for (int i = numberOfLists; i > 0; i--) {
            WebElement wishlistDeleteIcon = driver.findElement(By.cssSelector("td.wishlist_delete>a.icon"));
            wishlistDeleteIcon.click();
            wait.until(ExpectedConditions.alertIsPresent()).accept();
            wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector("td.wishlist_delete>a.icon"), i));
        }
    }


//    public void removeAllLists() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        while (!isWishlistEmpty()) {
//            WebElement wishlistDeleteIcon = driver.findElement(By.cssSelector("td.wishlist_delete>a.icon"));
//            wishlistDeleteIcon.click();
//            wait.until(ExpectedConditions.alertIsPresent()).accept();
////          driver.navigate().refresh();
//        }
//    }

    public void createNewWishlist(String wishlistName) {
        newWishlistNameInput.sendKeys(wishlistName);
        saveWishlist.click();
    }

    public void showCreatedList(String wishlistName) {
        driver.findElement(By.xpath("//a[contains(text(), '" + wishlistName + "')]")).click();
    }

    public void showList() {
        driver.findElement(By.xpath("//a[contains(text(), '" + defaultWishlistName + "')]")).click();
    }

    public boolean checkIfItemWasAddedToWishlist(String itemsName) {
        List<String> namesOfWishListItems = new ArrayList<>();
        if (!isWishlistEmpty()) {//
            List<WebElement> wishlistItems = driver.findElements(By.cssSelector("ul.wlp_bought_list>li"));
            wishlistItems.forEach(item -> namesOfWishListItems.add(item.findElement(By.cssSelector("img")).getAttribute("alt")));
            System.out.println("items in selected list: ");
            namesOfWishListItems.forEach(System.out::println);
        }
        return namesOfWishListItems.contains(itemsName);
    }
}