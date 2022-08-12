package com.coherentsolutions.training.automation.java.web.urnezaite;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CartTest extends BaseTest {

    @Test
    @Description("Verify the ability to add to cart")
    public void testCart() {
        MyAccountPage myAccountPage = logIn();
        HomePage homePage = myAccountPage.goToHomePage();
        List<String> itemsAddedToCart = new ArrayList<>();

        while (itemsAddedToCart.size() != 3) {
            ItemPage itemPage = homePage.selectRandomItem();
            if (!itemsAddedToCart.contains(itemPage.getItemsReference())) {
                String itemAddedToCart = itemPage.getItemsReference();
                itemPage.addToCart();
                itemsAddedToCart.add(itemAddedToCart);
                homePage = itemPage.goToHomePage();
            }
        }
        CartPage cartPage = homePage.goToCartPage();

        Assert.assertTrue(cartPage.isItemsInCart(itemsAddedToCart), "items were not added to cart");
    }
}