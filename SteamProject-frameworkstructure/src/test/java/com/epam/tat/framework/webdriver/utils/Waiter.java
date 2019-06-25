package com.epam.tat.framework.webdriver.utils;

import com.epam.tat.framework.webdriver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final int WAIT_TIME_SECONDS = 10;

    public static void waitUntilSwitch(String webElement) {
        LOGGER.info("Wait frame " + webElement + " and switch to it");
        new WebDriverWait(Driver.getDriver(), WAIT_TIME_SECONDS).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(webElement));
    }

    public static void waitUntilClickable(WebElement webElement) {
        new WebDriverWait(Driver.getDriver(), WAIT_TIME_SECONDS).until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void waitUntilVisibilityOfElement(WebElement webElement) {
        new WebDriverWait(Driver.getDriver(), WAIT_TIME_SECONDS).until(ExpectedConditions.visibilityOf(webElement));
    }

}
