package com.epam.tat.framework.webdriver.listener;

import com.epam.reportportal.testng.ReportPortalTestNGListener;
import com.epam.tat.framework.webdriver.screenshot.ScreenshotSaver;
import org.testng.ITestResult;

public class ReportPortalListener extends ReportPortalTestNGListener{

    private ScreenshotSaver saveScreenshot = new ScreenshotSaver();

    @Override
    public void onTestSuccess(ITestResult testResult) {
        super.onTestSuccess(testResult);
    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        super.onTestFailure(testResult);
        saveScreenshot.saveScreenshot();
    }
}
