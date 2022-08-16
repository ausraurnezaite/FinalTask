package com.coherentsolutions.training.automation.java.web.urnezaite;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    @Description("Verify the ability to log in")
    public void testLogIn() {
        MyAccountPage myAccountPage = logIn();
        Assert.assertTrue(myAccountPage.isLoaded(), "log in was not successful");
    }

    @Test(dependsOnMethods = "testLogIn")
    @Description("Verify the ability to add to cart")
    public void testCart() {
        HomePage homePage = new HomePage(driver);
        homePage.addProductsToCart(3);
        CartPage cartPage = homePage.goToCartPage();

        Assert.assertTrue(cartPage.isAddedItemsInCart(), "items were not added to cart");
    }
}