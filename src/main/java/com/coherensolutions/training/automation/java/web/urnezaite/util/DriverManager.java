package com.coherensolutions.training.automation.java.web.urnezaite.util;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private static void initializeDriver() {
        TestRunStrategy strategy = getStrategy(PropertyProvider.getProperty("env"));
        driver.set(strategy.initializeDriver(PropertyProvider.getProperty("browser")));
    }

    public static synchronized WebDriver getDriver() {
        if (driver.get() == null) {
            initializeDriver();
        }
        return driver.get();
    }

    private static TestRunStrategy getStrategy(String strategy) {
        if (strategy.equalsIgnoreCase("local")) {
            return new LocalStrategy();
        }
        return new SauceLabsStrategy();
    }
}

//    public static void setDriverToContext(ITestContext iTestContext, WebDriver driver) {
//        iTestContext.setAttribute("WebDriver", driver);
//    }
//
//    public static WebDriver getDriverFromContext(ITestContext iTestContext) {
//        return (WebDriver) iTestContext.getAttribute("WebDriver");
//    }
