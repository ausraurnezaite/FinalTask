package com.coherentsolutions.training.automation.java.web.urnezaite;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    @FindBy(css = "a.home")
    private WebElement homeButton;

    @FindBy(css = "td.cart_description small.cart_ref")
    private List<WebElement> cartItems;

    private final Logger logger = LogManager.getLogger(CartPage.class);

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public HomePage goToHomePage() {
        homeButton.click();
        return new HomePage(driver);
    }

    public boolean isItemsInCart(List<String> itemsAddedToCart) {
        List<String> namesOfItemsInCart = new ArrayList<>();
        cartItems.forEach(item -> namesOfItemsInCart.add(item.getText().replace("SKU : ", "")));
        logger.info("items in cart: " + namesOfItemsInCart);
        return namesOfItemsInCart.containsAll(itemsAddedToCart);
    }
}