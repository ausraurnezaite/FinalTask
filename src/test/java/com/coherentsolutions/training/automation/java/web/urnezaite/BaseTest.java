package com.coherentsolutions.training.automation.java.web.urnezaite;

import com.coherentsolutions.training.automation.java.web.urnezaite.util.DriverManager;
import com.coherentsolutions.training.automation.java.web.urnezaite.util.FailedTestListener;
import com.coherentsolutions.training.automation.java.web.urnezaite.util.PropertyProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners({FailedTestListener.class})
public class BaseTest {
    protected WebDriver driver;
    protected final static String USERNAME = PropertyProvider.getProperty("username");
    protected final static String PASSWORD = System.getenv("TEST_PASSWORD");
    protected final static String LOGIN_PAGE_LINK = PropertyProvider.getProperty("loginPageLink");
    private static final Logger logger = LogManager.getLogger();

    @BeforeClass
    public void setUp(ITestContext context) {
        driver = DriverManager.getDriver();
    }

    @AfterClass
    public void cleanUp() {
        driver.close();
    }

    protected MyAccountPage logIn() {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.load(LOGIN_PAGE_LINK);
        MyAccountPage myAccountPage = logInPage.logIn(USERNAME, PASSWORD);
        return myAccountPage;
    }
}