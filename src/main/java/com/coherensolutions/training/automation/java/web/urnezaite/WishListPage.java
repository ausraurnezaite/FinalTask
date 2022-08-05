package com.coherensolutions.training.automation.java.web.urnezaite;

import com.coherensolutions.training.automation.java.web.urnezaite.util.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage extends DriverManager {
    private WebDriver driver;

    @FindBy(css = "a.home")
    private WebElement homeButton;

    @FindBy(xpath = "//a[@title = 'View my shopping cart']")
    private WebElement cartButton;

    public WishListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage goToHomePage() {
        homeButton.click();
        return new MainPage(driver);
    }

    public CartPage goToCartPage() {
        cartButton.click();
        return new CartPage(driver);
    }

}