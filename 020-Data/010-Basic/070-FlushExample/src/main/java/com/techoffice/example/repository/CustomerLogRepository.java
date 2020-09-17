package com.techoffice.example.repository;

import com.techoffice.example.model.CustomerLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerLogRepository extends JpaRepository<CustomerLog, Integer> {
}
