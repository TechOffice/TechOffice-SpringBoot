package com.techoffice.example.controller;

import com.techoffice.example.model.Customer;
import com.techoffice.example.model.CustomerLog;
import com.techoffice.example.repository.CustomerLogRepository;
import com.techoffice.example.repository.CustomerRepository;
import com.techoffice.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class SampleController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerLogRepository customerLogRepository;

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/")
    public String home() {
        return "welcome";
    }

    @RequestMapping("/listCustomer")
    public List<Customer> listCustomer() {
        return customerRepository.findAll();
    }

    @RequestMapping("/updateCustomerWithId1")
    public Customer updateCustomerWithId1(){
        return customerService.updateCustomerWithId1();
    }

    @RequestMapping("/updateCustomerWithId1AfterFewSecond")
    public Customer updateCustomerWithId1AfterFewSecond(){
        return customerService.updateCustomerWithId1AfterFewSecond();
    }

    @RequestMapping("/listCustomerLog")
    public List<CustomerLog> listCustomerLog(){
        return customerLogRepository.findAll();
    }

    @RequestMapping("/initCustomers")
    public List<Customer> initCustomers(){
        return customerService.initCustomers();
    }


}
