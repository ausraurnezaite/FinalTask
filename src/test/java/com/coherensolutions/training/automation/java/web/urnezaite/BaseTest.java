package com.coherensolutions.training.automation.java.web.urnezaite;

import com.coherensolutions.training.automation.java.web.urnezaite.util.*;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners({FailedTestListener.class})
public class BaseTest extends DriverManager {
    public WebDriver driver;

    @BeforeClass
    public void setUp(ITestContext context) {
        driver = DriverManager.getDriver();
    }

    @AfterClass
    public void cleanUp() {
        driver.close();
    }
}