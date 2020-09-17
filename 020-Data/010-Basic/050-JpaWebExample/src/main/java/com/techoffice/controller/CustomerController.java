package com.techoffice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techoffice.model.Customer;
import com.techoffice.service.CustomerService;

@RestController()
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/")
	public String home(){
		return "customer";
	}
	
	@RequestMapping("/findAll")
	public List<Customer> findAll(){
		return customerService.findAll();
	}
	
	@RequestMapping("/update")
	public Customer create(@RequestBody Customer customer){
		return customerService.update(customer);
	}
	
	
}
