package com.techoffice.util;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class DateUtil {
    public static Date getCurrentDate() {
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY/mm/dd");
            simpleDateFormat.parse("2020/02/25");
            return new Date();
        }catch (Exception e){
            log.error(e.getMessage(), e);
        }
        return null;
    }
}
