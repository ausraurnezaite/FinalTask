package com.coherentsolutions.training.automation.java.web.urnezaite.util;

import org.openqa.selenium.WebDriver;

public interface TestRunStrategy {
    WebDriver initializeDriver(String browser);
}