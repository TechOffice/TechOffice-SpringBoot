package com.techoffice.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    @JsonIgnoreProperties("customerList")
    @ManyToMany
    @JoinTable(
            name="customer_group_mapping",
            joinColumns=@JoinColumn(name="customerId"),
            inverseJoinColumns=@JoinColumn(name="customerGroupId"))
    private List<CustomerGroup> customerGroupList;

    protected Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

    public List<CustomerGroup> createOrReturnCustomerGroupList(){
        if (this.customerGroupList == null){
            this.customerGroupList = new ArrayList<>();
        }
        return this.customerGroupList;
    }
}
