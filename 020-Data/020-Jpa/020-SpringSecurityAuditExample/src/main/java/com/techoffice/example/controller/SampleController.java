package com.techoffice.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techoffice.example.model.Customer;
import com.techoffice.example.repository.CustomerRepository;
import com.techoffice.example.service.CustomerService;

@Controller
public class SampleController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/")
	public String home() {
		return "welcome";
	}
	
	@ResponseBody
	@RequestMapping("/save")
	public Customer save(@RequestBody Customer customer){
		return customerRepository.save(customer);
	}

	@ResponseBody
	@RequestMapping("/createCustomer")
	public Customer createCustomer(){
		Customer customer = new Customer();
		customer.setFirstName("Tesinter");
		customerRepository.save(customer);
		return customer;
	}

	@ResponseBody
	@RequestMapping("/updateCustomer")
	public Customer updateCustomer(){
		return customerService.update();
	}


}
