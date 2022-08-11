package com.coherentsolutions.training.automation.java.web.urnezaite.util;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private static void initializeDriver() {
        TestRunStrategy strategy = getStrategy(PropertyProvider.getProperty("env"));
        WebDriver webDriver = strategy.initializeDriver(PropertyProvider.getProperty("browser"));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.set(webDriver);
    }

    public static synchronized WebDriver getDriver() {
        if (driver.get() == null) {
            initializeDriver();
        }
        return driver.get();
    }

    private static TestRunStrategy getStrategy(String strategy) {
        if (strategy.equalsIgnoreCase("saucelabs")) {
            return new SauceLabsStrategy();
        } else if (strategy.equalsIgnoreCase("grid")) {
            return new GridStrategy();
        }
        return new LocalStrategy();
    }
}