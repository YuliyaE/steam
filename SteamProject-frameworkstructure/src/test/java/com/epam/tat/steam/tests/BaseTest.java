package com.epam.tat.steam.tests;

import com.epam.tat.framework.webdriver.Driver;
import com.epam.tat.framework.webdriver.utils.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

public abstract class BaseTest {

    private static final String PAGE_URL = "PAGE_URL";
   protected String steamPageUrl;

    private final Logger LOGGER = LogManager.getLogger();
    private SoftAssert softAssert;

    @BeforeClass
    public void setUp() {
      steamPageUrl = PropertyReader.getTestData(PAGE_URL);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        Driver.closeDriver();
    }
}
