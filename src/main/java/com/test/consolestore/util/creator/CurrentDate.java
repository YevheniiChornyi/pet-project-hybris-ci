package com.test.consolestore.util.creator;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDate {
    public static String currentDate(Date currentDate) {
       // Date currentDate = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("[yyyy-MM-dd hh:mm]");
        return formatForDateNow.format(currentDate);
    }
}
