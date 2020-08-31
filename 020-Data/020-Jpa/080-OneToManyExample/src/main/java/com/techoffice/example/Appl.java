package com.techoffice.example;

import com.techoffice.example.model.Table1;
import com.techoffice.example.model.Table2;
import com.techoffice.example.repository.Table1Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootApplication
public class Appl implements CommandLineRunner {

	@Autowired
	private Table1Repository repository;

	@Override
	public void run(String... arg0) throws Exception {
		Table1 table1 = new Table1();
		List<Table2> table2List = new ArrayList<>();
		Table2 table2 = new Table2();
		table2List.add(table2);
		table1.setTable2List(table2List);
		repository.save(table1);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Appl.class, args);
	}

}
