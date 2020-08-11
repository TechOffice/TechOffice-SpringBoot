package com.techoffice.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techoffice.example.model.Customer;
import com.techoffice.example.repository.CustomerRepository;

@Controller
public class SampleController {

	@RequestMapping("/")
	public String home() {
		return "welcome";
	}




}
