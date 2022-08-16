package com.coherentsolutions.training.automation.java.web.urnezaite;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutoWishlistTest extends BaseTest {

    @Test
    @Description("Verify the ability to log in")
    public void testLogIn() {
        MyAccountPage myAccountPage = logIn();
        Assert.assertTrue(myAccountPage.isLoaded(), "log in was not successful");
    }

    @Test(dependsOnMethods = "testLogIn")
    @Description("Verify the ability to add to auto-created Wishlist")
    public void testAutoCreatedWishlist() {

        WishlistPage wishlistPage = new WishlistPage(driver);

        if (!wishlistPage.isWishlistEmpty()) {
            wishlistPage.removeAllLists();
        }

        HomePage homePage = wishlistPage.goToHomePage();
        ItemPage itemPage = homePage.selectRandomItem();
        String itemAddedToWishListName = itemPage.getItemsName();
        itemPage.addToWishlist();
        wishlistPage = itemPage.goToMyAccountPage().goToWishListPage();
        wishlistPage.showList();
        Assert.assertTrue(wishlistPage.isItemInWishlist(itemAddedToWishListName), "item was not added to wishlist");
    }
}