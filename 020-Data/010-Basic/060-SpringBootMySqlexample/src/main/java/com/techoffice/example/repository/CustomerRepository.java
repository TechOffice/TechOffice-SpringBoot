package com.techoffice.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.techoffice.example.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
    List<Customer> findByLastName(String lastName);

}
