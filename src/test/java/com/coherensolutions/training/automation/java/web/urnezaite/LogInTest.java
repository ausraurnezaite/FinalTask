package com.coherensolutions.training.automation.java.web.urnezaite;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LogInTest extends BaseTest {

    @Test
    @Description("Verify the ability to login in account")
    public void testLogIn() {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.load(LOGIN_PAGE_LINK);
        MyAccountPage myAccountPage = logInPage.logIn(USERNAME, PASSWORD);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(myAccountPage.isTitleCorrect(), "title is not correct");
        softAssert.assertTrue(myAccountPage.isCartButtonDisplayed(), "cart button is not displayed");
        softAssert.assertTrue(myAccountPage.isWishListButtonDisplayed(), "wishlist button is not displayed");
        softAssert.assertTrue(USERNAME.equalsIgnoreCase(myAccountPage.getDisplayedAccountName()), "account name is not correct");
        softAssert.assertAll();
    }
}