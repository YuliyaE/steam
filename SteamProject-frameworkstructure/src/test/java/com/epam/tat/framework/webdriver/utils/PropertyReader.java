package com.epam.tat.framework.webdriver.utils;

import java.util.ResourceBundle;

public class PropertyReader {

    private static final ResourceBundle dataResourceBundle = ResourceBundle.getBundle(System.getProperty("datalist"));

    public static String getTestData(String key) {
        return dataResourceBundle.getString(key);
    }

}
