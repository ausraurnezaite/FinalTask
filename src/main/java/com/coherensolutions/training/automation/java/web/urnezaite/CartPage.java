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


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public MainPage goToHomePage() {
        homeButton.click();
        return new MainPage(driver);
    }


    public boolean checkIfItemsWereAddedToCart(List<String> itemsAddedToCart) {
        List<String> namesOfItemsInCart = new ArrayList<>();
        List<WebElement> cartItems = driver.findElements(By.cssSelector("td.cart_description"));
        cartItems.forEach(item -> namesOfItemsInCart.add(item.findElement(By.cssSelector("small.cart_ref")).getText().replace("SKU : ", "")));
        System.out.println("items in cart: ");
        namesOfItemsInCart.forEach(System.out::println);
        return namesOfItemsInCart.containsAll(itemsAddedToCart);
    }
}