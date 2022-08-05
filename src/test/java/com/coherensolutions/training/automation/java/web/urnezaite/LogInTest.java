package com.coherensolutions.training.automation.java.web.urnezaite;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LogInTest extends BaseTest {

    @Test
    @Description("Verify if the log in is successful")
    public void testLogIn() {

        LogInPage logInPage = new LogInPage(driver);
        logInPage.load();
        MyAccountPage myAccountPage = logInPage.logIn();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(myAccountPage.isHeadingDisplayed(), "heading is not displayed");
        softAssert.assertTrue(myAccountPage.isCartButtonDisplayed(), "cart button is not displayed");
        softAssert.assertTrue(myAccountPage.isWishListButtonDisplayed(), "wishlist is not displayed");
        softAssert.assertAll();
    }
}