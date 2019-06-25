package com.epam.tat.framework.webdriver.utils;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateAndTime {

    public static String getCurrentTimeAsString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}
