package com.coherensolutions.training.automation.java.web.urnezaite.util;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SauceLabsStrategy implements TestRunStrategy {
    private WebDriver driver;
    private MutableCapabilities sauceOptions = new MutableCapabilities();
    private DesiredCapabilities capabilities = new DesiredCapabilities();


    @Override
    public WebDriver initializeDriver(String browserName) {

        sauceOptions.setCapability("username", System.getenv("SAUCE_USERNAME"));
        sauceOptions.setCapability("access_key", System.getenv("SAUCE_ACCESS_KEY"));
        capabilities.setCapability("sauce:options", sauceOptions);

        capabilities.setCapability("platformName", PropertyProvider.getProperty("saucelabs.platform"));
        capabilities.setCapability("browserVersion", PropertyProvider.getProperty("saucelabs.browserversion"));

        if (browserName.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            capabilities.setBrowserName("firefox");
            options.merge(capabilities);
        } else {
            ChromeOptions options = new ChromeOptions();
            capabilities.setBrowserName("chrome");
            options.merge(capabilities);
        }

        try {
            URL sauceurl = new URL(PropertyProvider.getProperty("saucelabs.sauceurl"));
            driver = new RemoteWebDriver(sauceurl, capabilities);
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}