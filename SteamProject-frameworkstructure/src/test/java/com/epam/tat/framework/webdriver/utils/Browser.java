package com.epam.tat.framework.webdriver.utils;

import com.epam.tat.framework.webdriver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;


public abstract class Browser {
    private final Logger LOGGER = LogManager.getLogger();
    protected final WebDriver driver = Driver.getDriver();

    public static void openPage(String steamPageUrl) {
         Driver.getDriver().get(steamPageUrl);
    }

    protected void switchToDefaulFrame() {
        LOGGER.info("Switch to default frame");
        driver.switchTo().defaultContent();
    }

    protected void openNewTab() {
        LOGGER.info("Open new tab");
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }

    protected void tabSwitchPreviousTab() {
        LOGGER.info("Switch to previous tab");
        ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 2));
    }

}
