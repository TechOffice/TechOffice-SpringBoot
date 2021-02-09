package com.techoffice.example.service;

import com.techoffice.example.model.Customer;
import com.techoffice.example.repository.CustomerRepository;
import com.techoffice.example.specs.CustomerSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findByName(String name){
        return customerRepository.findAll(Specification.where(CustomerSpecs.byFirstName(name)));
    }

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    public List<Customer> findByGroupName(String name){
        return customerRepository.findAll(CustomerSpecs.byCustomerGroupName(name).and(CustomerSpecs.byFirstName("Hello")));
    }
}
