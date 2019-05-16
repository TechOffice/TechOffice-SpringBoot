package com.techoffice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techoffice.entity.Student;
import com.techoffice.repository.StudentRepository;

@RestController
@EnableAutoConfiguration
public class SpringBootExampleAppl {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@RequestMapping("/")
    String home() {
        return "Hello World!";
    }
	
	@RequestMapping("/add")
    String add() {
		Student student = new Student();
		student.setName("New Student");
		studentRepository.save(student);
        return "add!";
    }
	
	public static void main(String[] args){
        SpringApplication.run(SpringBootExampleAppl.class, args);
	}
}
