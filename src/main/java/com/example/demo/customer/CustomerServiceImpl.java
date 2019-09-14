package com.example.demo.customer;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private List<Customer> customers = new ArrayList<>();

    @Override
    public Customer createCustomer(Customer customer) {
        Customer tempCustomer = new Customer(customer.getName(), customer.getSurname(), customer.getBirthDate(), customer.getTelephoneNumber(), customer.getEmail());
        customers.add(tempCustomer);
        return customer;
    }

    @Override
    public List<Customer> getCustomers() {
        return customers;
    }
}
