package com.techoffice.service;

import com.techoffice.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Service
public class Test2Service {

    @Autowired
    private Test1Service test1Service;

    public String returnTestingString() {
        try {
            Date date = DateUtil.getCurrentDate();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY/mm/dd");
            simpleDateFormat.parse("2020/02/25");
            return simpleDateFormat.format(date);
        } catch (Exception e){
            log.error(e.getMessage(), e);
        }
        return "";
    }

}
