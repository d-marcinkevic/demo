package com.example.demo.customer;

import org.springframework.http.HttpStatus;

import java.util.List;

public interface CustomerService {

    HttpStatus createCustomer(Customer customer);
    List<Customer> getCustomers();
    Customer getCustomerByName(String name);
}
