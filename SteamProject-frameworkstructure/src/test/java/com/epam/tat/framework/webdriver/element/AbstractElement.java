package com.epam.tat.framework.webdriver.element;

import com.epam.tat.framework.webdriver.Driver;
import com.epam.tat.framework.webdriver.utils.Waiter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractElement implements Element {

    protected  WebElement webElement;
    private final Logger LOGGER = LogManager.getLogger();
    private static final int WAIT_TIME_SECONDS = 10;

    public AbstractElement(final WebElement webElement) {
        this.webElement = webElement;
        LOGGER.info("Get WebElement ");
    }
    public AbstractElement() {
        PageFactory.initElements(new ExtendedFieldDecorator(Driver.getDriver()), this);
        LOGGER.info("Get WebElement ");
    }

    public void click() {
        LOGGER.info("Wait until element " + webElement + " to be clickable and click");
        Waiter.waitUntilClickable(webElement);
        webElement.click();
    }

    public String getText() {
        LOGGER.info("Get text from element " + webElement);
        return webElement.getText();

    }

    public String getAttribute(String attribute) {
        LOGGER.info("Get attribute " + attribute + " from element " + webElement);
        return webElement.getAttribute(attribute);
    }

    public void moveToElement(WebElement webElement) {
        LOGGER.info("Move to element " + webElement);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(webElement).perform();
    }

}
