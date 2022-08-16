package com.coherentsolutions.training.automation.java.web.urnezaite;

import jdk.swing.interop.SwingInterOpUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomePage extends BasePage {

    @FindBy(css = "ul#homefeatured>li a.product-name")
    private List<WebElement> productsList;

    private static List<String> itemsAddedToCart = new ArrayList<>();

    private static final Logger logger = LogManager.getLogger();

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ItemPage selectRandomItem() {
        int random = new Random().nextInt(productsList.size());
        productsList.get(random).click();
        return new ItemPage(driver);
    }

    public void addProductsToCart(int amount) {
        if (amount < 0 || amount > productsList.size()) {
            logger.warn(String.format("amount of different products added to cart must be 0 - %d", productsList.size()));
            amount = amount > productsList.size() ? productsList.size() : 1;
            logger.warn(String.format("amount of different products added to cart changed to %d", amount));
        }
        while (itemsAddedToCart.size() != amount) {
            ItemPage itemPage = selectRandomItem();
            if (!itemsAddedToCart.contains(itemPage.getItemsReference())) {
                String itemAddedToCart = itemPage.getItemsReference();
                itemPage.addToCart();
                itemsAddedToCart.add(itemAddedToCart);
            }
            itemPage.goToHomePage();
        }
    }

    public static List<String> getItemsAddedToCart() {
        return itemsAddedToCart;
    }
}