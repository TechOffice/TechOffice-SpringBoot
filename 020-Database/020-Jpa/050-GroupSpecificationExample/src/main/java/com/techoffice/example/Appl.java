package com.techoffice.example;

import com.techoffice.example.model.CustomerGroup;
import com.techoffice.example.repository.CustomerGroupRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import com.techoffice.example.model.Customer;
import com.techoffice.example.repository.CustomerRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Appl implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(Appl.class);

	@Autowired
	private CustomerRepository repository;

	@Autowired
	private CustomerGroupRepository customerGroupRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		CustomerGroup customerGroup1 = new CustomerGroup();
		customerGroup1.setName("Group 1");

		CustomerGroup customerGroup2 = new CustomerGroup();
		customerGroup2.setName("Group 2");

		Customer customer1 = new Customer("Jack", "Bauer");
		Customer customer2 = new Customer("Chloe", "O'Brian");
		Customer customer3 = new Customer("Hello", "Bauer");
		Customer customer4 = new Customer("Hello", "Dessler");
		Customer customer5 = new Customer("Hello", "World");

		customer1.createOrReturnCustomerGroupList().add(customerGroup1);
		customer3.createOrReturnCustomerGroupList().add(customerGroup1);
		customer4.createOrReturnCustomerGroupList().add(customerGroup1);

		customer1.createOrReturnCustomerGroupList().add(customerGroup2);
		customer2.createOrReturnCustomerGroupList().add(customerGroup2);
		customer3.createOrReturnCustomerGroupList().add(customerGroup2);
		customer4.createOrReturnCustomerGroupList().add(customerGroup2);
		customer5.createOrReturnCustomerGroupList().add(customerGroup2);

		customerGroupRepository.save(customerGroup1);
		customerGroupRepository.save(customerGroup2);

		repository.save(customer1);
		repository.save(customer2);
		repository.save(customer3);
		repository.save(customer4);
		repository.save(customer5);

		// fetch all customers
		log.info("Customers found with findAll():");
		log.info("-------------------------------");
		for (Customer customer : repository.findAll()) {
			log.info(customer.toString());
		}
		log.info("");

		// fetch an individual customer by ID


		// fetch customers by last name
		log.info("Customer found with findByLastName('Bauer'):");
		log.info("--------------------------------------------");
		for (Customer bauer : repository.findByLastName("Bauer")) {
			log.info(bauer.toString());
		}
		log.info("");	

	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Appl.class, args);
	}

}
