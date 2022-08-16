package com.coherentsolutions.training.automation.java.web.urnezaite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyAccountPage extends BasePage {

    private static final String TITLE = "My account - My Store";

    @FindBy(css = "a.home")
    private WebElement homeButton;

    @FindBy(css = "a.account>span")
    private List<WebElement> usersName;

    @FindBy(xpath = "//a[@title = 'My wishlists']")
    private List<WebElement> wishListButton;

    @FindBy(xpath = "//a[@title = 'View my shopping cart']")
    protected List<WebElement> cartButton;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public WishlistPage goToWishListPage() {
        wishListButton.get(0).click();
        return new WishlistPage(driver);
    }

    public HomePage goToHomePage() {
        homeButton.click();
        return new HomePage(driver);
    }

    public boolean isLoaded() {
        return isTitleCorrect() && isCartButtonDisplayed() && isWishListButtonDisplayed() && isUsersNameDisplayed();
    }

    public boolean isTitleCorrect() {
        return TITLE.equals(driver.getTitle());
    }

    public boolean isCartButtonDisplayed() {
        return cartButton.size() > 0;
    }

    public boolean isWishListButtonDisplayed() {
        return wishListButton.size() > 0;
    }

    public boolean isUsersNameDisplayed() {
        return usersName.size() > 0;
    }
}