package com.techoffice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techoffice.model.Customer;
import com.techoffice.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Transactional
	public Customer insert(Customer customer){
		return customerRepository.save(customer);
	}
	
	@Transactional
	public Customer update(Customer customer){
		return customerRepository.save(customer);
	}
	
	@Transactional
	public void delete(Customer customer){
		customerRepository.delete(customer);
	}
	
	@Transactional
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}
}
