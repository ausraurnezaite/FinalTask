package com.coherensolutions.training.automation.java.web.urnezaite.util;

import org.openqa.selenium.WebDriver;

public interface TestRunStrategy {
    WebDriver initializeDriver(String browser);
}