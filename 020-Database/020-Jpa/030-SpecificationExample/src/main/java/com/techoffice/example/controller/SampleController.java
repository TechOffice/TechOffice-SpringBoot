package com.techoffice.example.controller;

import com.techoffice.example.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techoffice.example.model.Customer;
import com.techoffice.example.repository.CustomerRepository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SampleController {

	@Autowired
	CustomerService customerService;

	@RequestMapping("/")
	@ResponseBody
	public String home() {
		return "welcome";
	}


	@RequestMapping("/jackCustomer")
	@ResponseBody
	public List<Customer> getCusomer(){
		return this.customerService.findByName("Jack");
	}

	@RequestMapping("/all")
	@ResponseBody
	public List<Customer> findAll(){
		return this.customerService.findAll();
	}

}
