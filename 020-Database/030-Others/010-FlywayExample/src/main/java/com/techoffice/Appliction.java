package com.techoffice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techoffice.entity.Student;
import com.techoffice.repository.StudentRepository;

import java.util.List;

@RestController
@SpringBootApplication
public class Appliction {
	
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
        return "added student with id: " + student.getId();
    }

	@RequestMapping("/list")
	List<Student> list() {
		return this.studentRepository.findAll();
	}


	public static void main(String[] args){
        SpringApplication.run(Appliction.class, args);
	}
}
