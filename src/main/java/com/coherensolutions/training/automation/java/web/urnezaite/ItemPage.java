package com.coherensolutions.training.automation.java.web.urnezaite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ItemPage extends BasePage {

    @FindBy(xpath = "//a[@title = 'View my customer account']")
    private WebElement myAccountButton;

    @FindBy(css = "p#add_to_cart>button")
    private WebElement addToCartButton;

    @FindBy(css = "a#wishlist_button")
    private WebElement addToWishlistButton;

    @FindBy(css = "h1")
    private WebElement itemsNameElement;

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public String addToWishlist() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String itemsName = itemsNameElement.getText();
        addToWishlistButton.click();
        System.out.println("item added to wishlist: " + itemsName);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a.fancybox-close"))).click();
        return itemsName;
    }

}