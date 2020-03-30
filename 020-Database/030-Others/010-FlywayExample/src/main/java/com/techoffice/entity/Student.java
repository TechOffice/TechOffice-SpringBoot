package com.techoffice.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Student {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String name;

}
