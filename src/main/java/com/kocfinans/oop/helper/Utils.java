package com.kocfinans.oop.helper;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

@Component
public class Utils {

    public static Timestamp getCurrentTimestamp() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Istanbul"));
        calendar.setTimeInMillis(System.currentTimeMillis());
        return formatter(calendar);
    }

    public static Timestamp formatter(Calendar calendar) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("Europe/Istanbul"));
        return Timestamp.valueOf(format.format(calendar.getTime()));
    }

    public static boolean isEmptyString(String value) {
        return (value == null || value.trim().isEmpty());
    }
}
