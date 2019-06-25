package com.epam.tat.framework.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Driver {
    private static final Logger LOGGER = LogManager.getLogger();
    private static WebDriver driver = null;

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (System.getProperty("browser")) {
                case "opera": {
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    LOGGER.info("Set up webdriver for Opera");
                    break;
                }
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    LOGGER.info("Set up webdriver for FireFox");
                    break;
                }
                case "edge": {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    LOGGER.info("Set up webdriver for Edge");
                    break;
                }
                default: {
                    ChromeOptions options = new ChromeOptions();
                    options.setCapability("platformName", Platform.WINDOWS);
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    LOGGER.info("Set up webdriver for Chrome");
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        LOGGER.info("Close webdriver");
        driver = null;
    }
}
