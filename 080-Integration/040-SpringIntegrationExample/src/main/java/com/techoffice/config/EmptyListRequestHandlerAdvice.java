package com.techoffice.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.handler.advice.AbstractRequestHandlerAdvice;
import org.springframework.messaging.Message;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Slf4j
public class EmptyListRequestHandlerAdvice extends AbstractRequestHandlerAdvice {

    @Override
    protected List<String> doInvoke(ExecutionCallback callback, Object o, Message<?> message) {
        List<String> result = (List<String>) callback.execute();
        if (result == null){
            log.info("result is null");
            return new ArrayList<String>();
        }else {
            log.info("result is not null");
            return result;
        }
    }
}
