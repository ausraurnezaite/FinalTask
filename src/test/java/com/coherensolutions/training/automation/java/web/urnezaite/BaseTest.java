package com.coherensolutions.training.automation.java.web.urnezaite;

import com.coherensolutions.training.automation.java.web.urnezaite.util.*;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners({FailedTestListener.class})
public class BaseTest {
    public WebDriver driver;
    final String USERNAME = PropertyProvider.getProperty("username");
    final String PASSWORD = System.getenv("TEST_PASSWORD");
    final String LOGIN_PAGE_LINK = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    @BeforeClass
    public void setUp(ITestContext context) {
        driver = DriverManager.getDriver();
    }

//    @AfterClass
//    public void cleanUp() {
//        driver.close();
//    }

    public MyAccountPage logIn() {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.load(LOGIN_PAGE_LINK);
        MyAccountPage myAccountPage = logInPage.logIn(USERNAME, PASSWORD);
        return myAccountPage;
    }
}