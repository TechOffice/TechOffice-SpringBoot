package com.techoffice.example.specs;

import com.techoffice.example.model.Customer;
import org.springframework.data.jpa.domain.Specification;

public class CustomerSpecs {

    public static Specification<Customer> byFirstName(final String name) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("firstName"), name);
        };
    }

}
