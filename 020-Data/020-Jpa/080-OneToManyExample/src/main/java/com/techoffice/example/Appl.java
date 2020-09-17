package com.techoffice.example;

import com.techoffice.example.service.Table1Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Appl implements CommandLineRunner {

	@Autowired
	private Table1Service table1Service;

	@Override
	public void run(String... arg0) throws Exception {
		table1Service.initTable1Data();
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Appl.class, args);
	}

}
