package com.coherentsolutions.training.automation.java.web.urnezaite.util;

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


    @Override
    public WebDriver initializeDriver(String browserName) {

        if (browserName.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            capabilities.setBrowserName("firefox");
            capabilities.setCapability("platformName", PropertyProvider.getProperty("grid.firefox.browser.platform"));
            capabilities.setCapability("browserVersion", PropertyProvider.getProperty("grid.firefox.browser.version"));

            options.merge(capabilities);
        } else {
            ChromeOptions options = new ChromeOptions();
            capabilities.setBrowserName("chrome");
            capabilities.setCapability("platformName", PropertyProvider.getProperty("grid.chrome.browser.platform"));
            capabilities.setCapability("browserVersion", PropertyProvider.getProperty("grid.chrome.browser.version"));
            options.merge(capabilities);
        }

        try {
            URL gridUrl = new URL(PropertyProvider.getProperty("grid.gridurl"));
            driver = new RemoteWebDriver(gridUrl, capabilities);

        } catch (MalformedURLException e) {
            Log.error(e.getMessage());
        }
        return driver;
    }
}