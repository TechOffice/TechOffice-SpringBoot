package com.techoffice.example.service;

import com.techoffice.example.model.Customer;
import com.techoffice.example.repository.CustomerRepository;
import com.techoffice.example.specs.CustomerSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findByName(String name){

        return customerRepository.findAll(CustomerSpecs.byFirstName(name));
    }

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    public List<Customer> findByGroupName(String name){
        customerRepository.count(CustomerSpecs.groupByCustomerGroup());
        return customerRepository.findAll();
    }
}
