package com.coherentsolutions.training.automation.java.web.urnezaite;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemPage extends BasePage {

    @FindBy(css = "a.home")
    private WebElement homeButton;

    @FindBy(css = "p#add_to_cart>button")
    private WebElement addToCartButton;

    @FindBy(css = "span.cross")
    private WebElement closeButtonAfterAddingToCart;

    @FindBy(css = "a#wishlist_button")
    private WebElement addToWishlistButton;

    @FindBy(css = "a.fancybox-close")
    private WebElement closeButtonAfterAddingToWishlist;

    @FindBy(css = "h1")
    private WebElement itemsNameElement;

    @FindBy(css = "p#product_reference>span")
    private WebElement itemsReferenceElement;

    private static final Logger logger = LogManager.getLogger(ItemPage.class);

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public void addToWishlist() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        addToWishlistButton.click();
        logger.info("item added to wishlist: " + itemsNameElement.getText());
        wait.until(ExpectedConditions.visibilityOf(closeButtonAfterAddingToWishlist)).click();
    }

    public void addToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        addToCartButton.click();
        logger.info("item added to cart: " + itemsReferenceElement.getText());
        wait.until(ExpectedConditions.visibilityOf(closeButtonAfterAddingToCart)).click();
    }

    public HomePage goToHomePage() {
        homeButton.click();
        return new HomePage(driver);
    }

    public String getItemsReference() {
        return itemsReferenceElement.getText();
    }

    public String getItemsName() {
        return itemsNameElement.getText();
    }
}