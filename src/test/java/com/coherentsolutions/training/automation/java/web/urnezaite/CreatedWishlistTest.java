package com.coherentsolutions.training.automation.java.web.urnezaite;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreatedWishlistTest extends BaseTest {
    private final String WISHLIST_NAME = "list";

    @Test
    @Description("Verify the ability to add to your Wishlist")
    public void testSelfCreatedWishlist() {
        MyAccountPage myAccountPage = logIn();
        WishlistPage wishlistPage = myAccountPage.goToWishListPage();
        wishlistPage.createNewWishlist(WISHLIST_NAME);
        HomePage homePage = wishlistPage.goToHomePage();
        ItemPage itemPage = homePage.selectRandomItem();
        String itemAddedToWishlistName = itemPage.getItemsName();
        itemPage.addToWishlist();
        wishlistPage = itemPage.goToMyAccountPage().goToWishListPage();
        wishlistPage.showCreatedList(WISHLIST_NAME);

        Assert.assertTrue(wishlistPage.isItemInWishlist(itemAddedToWishlistName), "item was not added to created wishlist");
    }

    @Test
    @Description("Verify the ability to add to your Wishlist when no list were created before")
    public void testSelfCreatedWishlistWhenNoListWereCreatedBefore() {

        WishlistPage wishlistPage = new WishlistPage(driver);

        if (!wishlistPage.isWishlistEmpty()) {
            wishlistPage.removeAllLists();
        }

        wishlistPage.createNewWishlist(WISHLIST_NAME);
        HomePage homePage = wishlistPage.goToHomePage();
        ItemPage itemPage = homePage.selectRandomItem();
        String itemsAddedToWishlistName = itemPage.getItemsName();
        itemPage.addToWishlist();
        wishlistPage = itemPage.goToMyAccountPage().goToWishListPage();
        wishlistPage.showCreatedList(WISHLIST_NAME);

        Assert.assertTrue(wishlistPage.isItemInWishlist(itemsAddedToWishlistName), "item was not added to created wishlist");
    }
}