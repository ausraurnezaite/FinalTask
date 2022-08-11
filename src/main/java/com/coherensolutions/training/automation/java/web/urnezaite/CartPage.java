package com.coherensolutions.training.automation.java.web.urnezaite;

import com.coherensolutions.training.automation.java.web.urnezaite.util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        System.out.println("items in cart: ");
        namesOfItemsInCart.forEach(System.out::println);
        return namesOfItemsInCart.containsAll(itemsAddedToCart);
    }
}