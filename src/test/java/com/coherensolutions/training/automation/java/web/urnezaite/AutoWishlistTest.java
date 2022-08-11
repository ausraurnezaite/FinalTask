package com.coherensolutions.training.automation.java.web.urnezaite;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutoWishlistTest extends BaseTest {

    @Test
    @Description("Verify the ability to add to auto-created Wishlist")
    public void testAutoCreatedWishlist() {
        MyAccountPage myAccountPage = logIn();
        WishlistPage wishlistPage = myAccountPage.goToWishListPage();

        if (!wishlistPage.isWishlistEmpty()) {
            wishlistPage.removeAllLists();
        }
        MainPage mainPage = wishlistPage.goToHomePage();
        ItemPage itemPage = mainPage.selectRandomItem();
        String itemAddedToWishListName = itemPage.getItemsName();
        itemPage.addToWishlist();
        wishlistPage = itemPage.goToMyAccountPage().goToWishListPage();
        wishlistPage.showList();
        Assert.assertTrue(wishlistPage.checkIfItemWasAddedToWishlist(itemAddedToWishListName), "item was not added to wishlist");
    }
}