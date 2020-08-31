package com.techoffice.example.repository;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.EmptyInterceptor;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomSqlInterceptor extends EmptyInterceptor {
    @Override
    public String onPrepareStatement(String sql){
        log.info(sql);
        return sql;
    }
}