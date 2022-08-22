package com.coherentsolutions.training.automation.java.web.urnezaite.util;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FailedTestListener implements IInvokedMethodListener {
    private static String screenshotsSubFolderName;
    private static DateTimeFormatter DATE_TIME_FORMATTER_FULL = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    private static DateTimeFormatter DATE_TIME_FORMATTER_SHORT = DateTimeFormatter.ofPattern("ddMMyyyy.HHmmss");
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            WebDriver driver = DriverManager.getDriver();
            captureScreenshot(String.format("%s_%s_%s.png", testResult.getTestContext().getSuite().getName(), testResult.getTestContext().getName(), testResult.getName()), driver);
            Allure.addAttachment(testResult.getMethod().getMethodName(), new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            addTestInfo();
        }
    }

    public static void captureScreenshot(String fileName, WebDriver driver) {
        if (screenshotsSubFolderName == null) {
            LocalDateTime now = LocalDateTime.now();
            screenshotsSubFolderName = now.format(DATE_TIME_FORMATTER_SHORT);
        }
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(String.format("./Screenshots/%s/%s", screenshotsSubFolderName, fileName));

        try {
            FileUtils.copyFile(scrFile, destFile);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    public void addTestInfo() {
        LocalDateTime now = LocalDateTime.now();
        Allure.addAttachment("Time", now.format(DATE_TIME_FORMATTER_FULL));
        Allure.addAttachment("Browser", PropertyProvider.getProperty("browser"));
        if (!PropertyProvider.getProperty("env").equalsIgnoreCase("local")) {
            Allure.addAttachment("Browser.Version", PropertyProvider.getProperty("saucelabs.chrome.browser.version"));
            Allure.addAttachment("Platform", PropertyProvider.getProperty("saucelabs.chrome.browser.platform"));
        }
    }
}