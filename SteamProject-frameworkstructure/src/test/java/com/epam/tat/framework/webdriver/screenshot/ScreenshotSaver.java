package com.epam.tat.framework.webdriver.screenshot;

import com.epam.tat.framework.webdriver.Driver;
import com.epam.tat.framework.webdriver.utils.DateAndTime;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotSaver {

    private final Logger LOGGER = LogManager.getLogger();

    public void saveScreenshot(){
        File screenCapture = ((TakesScreenshot)
                Driver.getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                    ".//target/screenshots/"
                            +  DateAndTime.getCurrentTimeAsString() +
                            ".png"));
        } catch (IOException e) {
            LOGGER.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }

}
