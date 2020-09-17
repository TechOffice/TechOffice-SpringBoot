package com.techoffice.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.techoffice.example.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
    List<Customer> findByLastName(String lastName);

}
