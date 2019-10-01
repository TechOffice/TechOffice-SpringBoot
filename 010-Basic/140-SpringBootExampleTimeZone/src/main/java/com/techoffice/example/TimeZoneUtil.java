package com.techoffice.example;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public final class TimeZoneUtil {

    public static TimeZone HONGKONG = TimeZone.getTimeZone("Asia/Hong_Kong");
    public static TimeZone UTC = TimeZone.getTimeZone("UTC");

    private TimeZoneUtil(){}

    /**
     * Convert Date from UTC to Specified TimeZone without changing Date Time Value
     *
     * @param date
     * @return
     */
    public static Date convertDateFromUtcToTimezone(Date date, TimeZone timeZone){
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        fromCalendar.setTime(date);

        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTimeZone(timeZone);
        toCalendar.set(Calendar.YEAR, fromCalendar.get(Calendar.YEAR));
        toCalendar.set(Calendar.MONTH, fromCalendar.get(Calendar.MONTH));
        toCalendar.set(Calendar.DAY_OF_MONTH, fromCalendar.get(Calendar.DAY_OF_MONTH));
        toCalendar.set(Calendar.HOUR, fromCalendar.get(Calendar.HOUR));
        toCalendar.set(Calendar.MINUTE, fromCalendar.get(Calendar.MINUTE));
        toCalendar.set(Calendar.SECOND, fromCalendar.get(Calendar.SECOND));
        toCalendar.set(Calendar.MILLISECOND, fromCalendar.get(Calendar.MILLISECOND));

        return toCalendar.getTime();
    }

    /**
     * Convert Date from Specified TimeZone to UTC with changing Date Time Value
     */
    public static Date convertDateFromTimezoneToUtc(Date date, TimeZone timeZone){
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTimeZone(timeZone);
        fromCalendar.setTime(date);

        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        toCalendar.set(Calendar.YEAR, fromCalendar.get(Calendar.YEAR));
        toCalendar.set(Calendar.MONTH, fromCalendar.get(Calendar.MONTH));
        toCalendar.set(Calendar.DAY_OF_MONTH, fromCalendar.get(Calendar.DAY_OF_MONTH));
        toCalendar.set(Calendar.HOUR, fromCalendar.get(Calendar.HOUR));
        toCalendar.set(Calendar.MINUTE, fromCalendar.get(Calendar.MINUTE));
        toCalendar.set(Calendar.SECOND, fromCalendar.get(Calendar.SECOND));
        toCalendar.set(Calendar.MILLISECOND, fromCalendar.get(Calendar.MILLISECOND));

        return toCalendar.getTime();

    }

}
