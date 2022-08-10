package com.coherensolutions.training.automation.java.web.urnezaite.util;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
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

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class FailedTestListener implements IInvokedMethodListener {
    public static String screenshotsSubFolderName;

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            WebDriver driver = DriverManager.getDriver();
            captureScreenshot(testResult.getTestContext().getSuite().getName() + "_" + testResult.getTestContext().getName() + "_" + testResult.getName() + ".png", driver);
            Allure.addAttachment(testResult.getMethod().getMethodName(), new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            addTestInfo();
        }
    }

    public static void captureScreenshot(String fileName, WebDriver driver) {
        if (screenshotsSubFolderName == null) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyy.HHmmss");
            screenshotsSubFolderName = now.format(dtf);
        }
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File("./Screenshots/" + screenshotsSubFolderName + "/" + fileName);

        try {
            FileUtils.copyFile(scrFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addTestInfo() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        Allure.addAttachment("Time", now.format(dtf));
        Allure.addAttachment("Browser", PropertyProvider.getProperty("browser"));
        if (!PropertyProvider.getProperty("env").equalsIgnoreCase("local")) {
            Allure.addAttachment("Browser.Version", PropertyProvider.getProperty("saucelabs.chrome.browser.version"));
            Allure.addAttachment("Platform", PropertyProvider.getProperty("saucelabs.chrome.browser.platform"));
        }
    }
}