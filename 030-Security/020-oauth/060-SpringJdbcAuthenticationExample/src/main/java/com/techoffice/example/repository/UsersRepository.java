package com.techoffice.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techoffice.example.model.Users;

public interface UsersRepository extends JpaRepository<Users, String>{

	
}
