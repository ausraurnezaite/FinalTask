package com.coherensolutions.training.automation.java.web.urnezaite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemPage extends BasePage {

    @FindBy(xpath = "//a[@title = 'View my customer account']")
    private WebElement myAccountButton;

    @FindBy(css = "a.home")
    private WebElement homeButton;

    @FindBy(css = "p#add_to_cart>button")
    private WebElement addToCartButton;

    @FindBy(css = "a#wishlist_button")
    private WebElement addToWishlistButton;

    @FindBy(css = "h1")
    private WebElement itemsNameElement;

    @FindBy(css = "p#product_reference>span")
    private WebElement itemsReferenceElement;

    private String itemsName;
    private String itemsReference;


    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public String addToWishlist() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        itemsName = itemsNameElement.getText();
        addToWishlistButton.click();
        System.out.println("item added to wishlist: " + itemsName);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a.fancybox-close"))).click();
        return itemsName;
    }

    public String addToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        itemsReference = itemsReferenceElement.getText();
        addToCartButton.click();
        System.out.println("item added to cart: " + itemsReference);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.cross"))).click();
        return itemsReference;
    }

    public MainPage goToHomePage() {
        homeButton.click();
        return new MainPage(driver);
    }

    public String getItemsReference() {
        itemsReference = itemsReferenceElement.getText();
        return itemsReference;
    }
}