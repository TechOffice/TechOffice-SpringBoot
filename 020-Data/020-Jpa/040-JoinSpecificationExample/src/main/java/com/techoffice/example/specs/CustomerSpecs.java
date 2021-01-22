package com.techoffice.example.specs;

import com.techoffice.example.model.Customer;
import com.techoffice.example.model.CustomerGroup;
import com.techoffice.example.model.Customer_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;

public class CustomerSpecs {

    public static Specification<Customer> byFirstName(String name) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.and(criteriaBuilder.equal(root.get(Customer_.FIRST_NAME), name));
    }

    public static Specification<Customer> byCustomerGroupName(final String name){
        return ((root, query, criteriaBuilder) -> {
            Join<CustomerGroup, Customer> customerGroupCustomerJoin =  root.join("customerGroupList");
            return criteriaBuilder.and(criteriaBuilder.equal(customerGroupCustomerJoin.get("name"), name));
        });
    }


}
