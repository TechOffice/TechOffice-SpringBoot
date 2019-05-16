package com.techoffice.example.specs;

import com.techoffice.example.model.Customer;
import com.techoffice.example.model.CustomerGroup;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;

public class CustomerSpecs {

    public static Specification<Customer> byFirstName(String name) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.and(criteriaBuilder.equal(root.get("firstName"), name));
        };
    }

    public static Specification<Customer> byCustomerGroupName(final String name){
        return ((root, query, criteriaBuilder) -> {
            Join<CustomerGroup, Customer> customerGroupCustomerJoin =  root.join("customerGroupList");
            return criteriaBuilder.and(criteriaBuilder.equal(customerGroupCustomerJoin.get("name"), name));
        });
    }

    public static Specification<Customer> groupByCustomerGroup(){
        return (((root, criteriaQuery, criteriaBuilder) -> {
            Join<CustomerGroup, Customer> customerGroupCustomerJoin =  root.join("customerGroupList");
            return criteriaQuery.groupBy(customerGroupCustomerJoin.get("name")).getGroupRestriction();
        }));
    }

}
