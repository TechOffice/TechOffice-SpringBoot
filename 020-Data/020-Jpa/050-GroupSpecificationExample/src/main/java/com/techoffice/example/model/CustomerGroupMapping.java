package com.techoffice.example.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Data
//@Entity
public class CustomerGroupMapping {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Long customerId;

    private Long customerGroupId;

}
