package com.coherensolutions.training.automation.java.web.urnezaite;

import com.coherensolutions.training.automation.java.web.urnezaite.util.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends DriverManager {
    private WebDriver driver;

    private final String MY_ACCOUNT_URL = "http://automationpractice.com/index.php?controller=my-account";
    private final String TITLE = "My account - My Store";

    @FindBy(xpath = "//*[text() = 'My account']")
    private WebElement myAccountHeading;

    @FindBy(xpath = "//a[@title = 'Information']")
    private WebElement myPersonalInformationButton;

    @FindBy(xpath = "//a[@title = 'My wishlists']")
    private WebElement wishListButton;

    @FindBy(xpath = "//a[@title = 'View my shopping cart']")
    private WebElement cartButton;

    @FindBy(css = "a.home")
    private WebElement homeButton;

    @FindBy(css = "a.logout")
    private WebElement logOutButton;


    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CartPage goToCartPage() {
        cartButton.click();
        return new CartPage(driver);
    }

    public WishListPage goToWishListPage() {
        wishListButton.click();
        return new WishListPage(driver);
    }

    public boolean isHeadingDisplayed(){
        return myAccountHeading.isDisplayed();
    }

    public boolean isCartButtonDisplayed(){
        return cartButton.isDisplayed();
    }
    public boolean isWishListButtonDisplayed(){
        return wishListButton.isDisplayed();
    }

}