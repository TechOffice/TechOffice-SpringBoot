package com.techoffice.example.service;

import com.techoffice.example.model.CustomerLog;
import com.techoffice.example.repository.CustomerLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomerLogService {

    @Autowired
    private CustomerLogRepository customerLogRepository;

    public CustomerLog newCustomerLog(){
        CustomerLog customerLog = new CustomerLog();
        customerLogRepository.save(customerLog);
        customerLogRepository.flush();
        return customerLog;
    }
}
