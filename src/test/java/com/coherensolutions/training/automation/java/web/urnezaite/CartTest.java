package com.coherensolutions.training.automation.java.web.urnezaite;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CartTest extends BaseTest {

    private List<String> itemsAddedToCart = new ArrayList<>();

    @Test
    @Description("Verify the ability to add to cart")
    public void testCart() {
        MyAccountPage myAccountPage = logIn();

        MainPage mainPage = myAccountPage.goToHomePage();
        //adding 3 different random items to cart
        while (itemsAddedToCart.size() != 3) {
            ItemPage itemPage = mainPage.selectRandomItem();
            if (!itemsAddedToCart.contains(itemPage.getItemsReference())) {
                String itemAddedToCart = itemPage.addToCart();
                itemsAddedToCart.add(itemAddedToCart);
                mainPage = itemPage.goToHomePage();
            }
        }
        CartPage cartPage = mainPage.goToCartPage();

        Assert.assertTrue(cartPage.checkIfItemsWereAddedToCart(itemsAddedToCart), "items were not added to cart");
    }
}