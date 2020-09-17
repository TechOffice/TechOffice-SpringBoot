package com.techoffice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techoffice.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
    List<Customer> findByLastName(String lastName);

}
