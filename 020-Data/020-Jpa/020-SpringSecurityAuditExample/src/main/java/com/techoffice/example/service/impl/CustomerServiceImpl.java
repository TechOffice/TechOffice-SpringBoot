package com.techoffice.example.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techoffice.example.model.Customer;
import com.techoffice.example.repository.CustomerRepository;
import com.techoffice.example.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Transactional
	@Override
	public Customer update(){
		Customer customer = customerRepository.findOne(1L);
		if (customer == null){
			customer = new Customer();
			customer.setFirstName("Tesinter");
		}else {
			customer.setLastName("Testing Last Name");
		}
		customerRepository.save(customer);
		return customer;
	}
}
