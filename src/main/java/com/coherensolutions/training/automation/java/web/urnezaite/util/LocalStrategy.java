package com.coherensolutions.training.automation.java.web.urnezaite.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class LocalStrategy implements TestRunStrategy {
    private WebDriver driver;

    @Override
    public WebDriver initializeDriver(String browserName) {
        if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver();
            WebDriverManager.chromedriver().setup();
        }
        driver.manage().window().maximize();
        return driver;
    }
}