package com.techoffice.example.service;

import com.techoffice.example.model.Customer;
import com.techoffice.example.repository.CustomerLogRepository;
import com.techoffice.example.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerLogRepository customerLogRepository;

    @Autowired
    private CustomerLogService customerLogService;

    public List<Customer> initCustomers(){
        List<Customer> customerList = new ArrayList<>();
        Customer customer = new Customer("Tester1", "Tester1");
        customerList.add(customer);
        customerRepository.saveAll(customerList);
        return customerList;
    }

    public Customer updateCustomerWithId1(){
        Customer customer = customerRepository.getOne(1L);
        String originalName = customer.getFirstName();
        if (originalName.contains("_updated")){
            String prefix = originalName.split("_updated")[0];
            customer.setFirstName(prefix + "_updated" + (customer.getVersion() + 1));
        } else {
            customer.setFirstName(customer.getFirstName() + "_updated" + (customer.getVersion() + 1));
        }
        customerLogService.newCustomerLog();
        customerRepository.save(customer);
        return  customer;
    }

    public Customer updateCustomerWithId1AfterFewSecond(){
        Customer customer = customerRepository.getOne(1L);
        String originalName = customer.getFirstName();
        if (originalName.contains("_updated")){
            String prefix = originalName.split("_updated")[0];
            customer.setFirstName(prefix + "_updated" + (customer.getVersion() + 1));
        } else {
            customer.setFirstName(customer.getFirstName() + "_updated" + (customer.getVersion() + 1));
        }
        customerLogService.newCustomerLog();
//        try {
//            Thread.sleep(5000);
//        }catch (Exception e){
//            log.error(e.getMessage(), e);
//        }
        if (true){
            throw new RuntimeException("Test Exception");
        }
        customerRepository.save(customer);
        return  customer;
    }


}
