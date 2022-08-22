package com.coherentsolutions.training.automation.java.web.urnezaite.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class GridStrategy implements TestRunStrategy {
    private WebDriver driver;
    private DesiredCapabilities capabilities = new DesiredCapabilities();
    private static final Logger logger = LogManager.getLogger();


    @Override
    public WebDriver initializeDriver(String browserName) {

        if (browserName.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.setBrowserVersion(PropertyProvider.getProperty("grid.firefox.browser.version"));
            capabilities.setBrowserName("firefox");
            capabilities.setCapability("platformName", PropertyProvider.getProperty("grid.firefox.browser.platform"));

            options.merge(capabilities);
        } else {
            ChromeOptions options = new ChromeOptions();
            options.setBrowserVersion(PropertyProvider.getProperty("grid.chrome.browser.version"));
            capabilities.setBrowserName("chrome");
            capabilities.setPlatform(Platform.fromString(PropertyProvider.getProperty("grid.chrome.browser.platform")));
            options.merge(capabilities);
        }

        try {
            URL gridUrl = new URL(PropertyProvider.getProperty("grid.gridurl"));
            driver = new RemoteWebDriver(gridUrl, capabilities);

        } catch (MalformedURLException e) {
            logger.error(e.getMessage());
        }
        return driver;
    }
}