package com.epam.tat.framework.webdriver.listener;

import com.epam.tat.framework.webdriver.screenshot.ScreenshotSaver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private final Logger LOGGER = LogManager.getLogger();
    private ScreenshotSaver saveScreenshot = new ScreenshotSaver();

    @Override
    public void onTestStart(ITestResult iTestResult) {

        LOGGER.info("Start testing");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LOGGER.info("Success testing");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        LOGGER.error("Step failed. See screenshots.");
        saveScreenshot.saveScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        LOGGER.info("Test skipped ");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        LOGGER.info("Test finished");
    }

}

