package com.coherensolutions.training.automation.java.web.urnezaite;

import com.coherensolutions.training.automation.java.web.urnezaite.util.PropertyProvider;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegisterTest extends BaseTest {

    @Test
    @Description("Verify the ability to create an account")
    public void testRegistration() {

        LogInPage logInPage = new LogInPage(driver);
        logInPage.load();
        RegistrationPage registrationPage = logInPage.createAccount();
        MyAccountPage myAccountPage = registrationPage.register();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(myAccountPage.isHeadingDisplayed(), "heading is not displayed");
        softAssert.assertTrue(myAccountPage.isCartButtonDisplayed(), "cart button is not displayed");
        softAssert.assertTrue(myAccountPage.isWishListButtonDisplayed(), "wishlist button is not displayed");
    }
}