package com.techoffice.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techoffice.example.model.Authorities;

public interface AuthoritiesRepository extends JpaRepository<Authorities, Long>{

}
