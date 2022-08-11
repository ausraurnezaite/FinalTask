package com.coherensolutions.training.automation.java.web.urnezaite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    private final String TITLE = "My account - My Store";

    @FindBy(xpath = "//a[@title = 'Information']")
    private WebElement myPersonalInformationButton;

    @FindBy(css = "a.account>span")
    private WebElement usersName;

    @FindBy(xpath = "//a[@title = 'My wishlists']")
    private WebElement wishListButton;

    @FindBy(css = "a.home")
    private WebElement homeButton;


    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public WishlistPage goToWishListPage() {
        wishListButton.click();
        return new WishlistPage(driver);
    }

    public MainPage goToHomePage() {
        homeButton.click();
        return new MainPage(driver);
    }

    public boolean isTitleCorrect() {
        return TITLE.equals(driver.getTitle());
    }

    public boolean isCartButtonDisplayed() {
        return cartButton.isDisplayed();
    }

    public boolean isWishListButtonDisplayed() {
        return wishListButton.isDisplayed();
    }

    public boolean isUsersNameDisplayed() {
        return usersName.isDisplayed();
    }
}