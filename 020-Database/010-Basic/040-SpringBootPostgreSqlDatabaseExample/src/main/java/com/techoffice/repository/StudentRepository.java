package com.techoffice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.techoffice.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{

    Page<Student> findAll(Pageable pageable);
    Student findByNameAllIgnoringCase(String name);

}
