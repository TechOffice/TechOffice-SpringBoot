package com.techoffice.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import com.techoffice.example.model.Customer;
import com.techoffice.example.repository.CustomerRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;

@SpringBootApplication
public class Appl {

	private static final Logger log = LoggerFactory.getLogger(Appl.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Appl.class, args);
	}

}
