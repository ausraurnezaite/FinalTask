package com.coherentsolutions.training.automation.java.web.urnezaite;

import com.coherentsolutions.training.automation.java.web.urnezaite.user.UserData;
import com.coherentsolutions.training.automation.java.web.urnezaite.user.UserDataGenerator;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegisterTest extends BaseTest {
    UserData user = UserDataGenerator.generate();

    @Test
    @Description("Verify the ability to create an account")
    public void testRegistration() {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.load(LOGIN_PAGE_LINK);
        RegistrationPage registrationPage = logInPage.createAccount(USERNAME);
        MyAccountPage myAccountPage = registrationPage.register(user);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(myAccountPage.isUsersNameDisplayed(), "users full name is not displayed");
        softAssert.assertTrue(myAccountPage.isTitleCorrect(), "title is not correct");
        softAssert.assertTrue(myAccountPage.isCartButtonDisplayed(), "cart button is not displayed");
        softAssert.assertTrue(myAccountPage.isWishListButtonDisplayed(), "wishlist button is not displayed");
        softAssert.assertAll();
    }
}