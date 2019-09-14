package com.example.demo.customer;

import java.util.List;

public interface CustomerService {

    Customer createCustomer(Customer customer);
    List<Customer> getCustomers();
}
