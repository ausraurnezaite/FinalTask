package com.coherentsolutions.training.automation.java.web.urnezaite;

import com.coherentsolutions.training.automation.java.web.urnezaite.util.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    @FindBy(css = "a.home")
    private WebElement homeButton;

    @FindBy(css = "td.cart_description small.cart_ref")
    List<WebElement> cartItems;


    private List<String> namesOfItemsInCart = new ArrayList<>();


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public MainPage goToHomePage() {
        homeButton.click();
        return new MainPage(driver);
    }

    public boolean checkIfItemsWereAddedToCart(List<String> itemsAddedToCart) {
        cartItems.forEach(item -> namesOfItemsInCart.add(item.getText().replace("SKU : ", "")));
        Log.info("items in cart: " + namesOfItemsInCart);
        return namesOfItemsInCart.containsAll(itemsAddedToCart);
    }
}