package com.example.demo.customer;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private List<Customer> customers = new ArrayList<>();

    @Override
    public HttpStatus createCustomer(Customer customer) {
        Customer tempCustomer = new Customer(customer.getName(), customer.getSurname(), customer.getBirthDate(), customer.getTelephoneNumber(), customer.getEmail());
        for(Customer c : customers){
            if((tempCustomer.getName().equals(c.getName()) && tempCustomer.getSurname().equals(c.getSurname()) && tempCustomer.getBirthDate().equals(c.getBirthDate())) || (tempCustomer.getTelephoneNumber().equals(c.getTelephoneNumber()) || tempCustomer.getEmail().equals(c.getEmail()))){
                return HttpStatus.CONFLICT;
            }
        }
        if(customer.getName() == null || customer.getSurname() == null || customer.getBirthDate() == null || customer.getTelephoneNumber() == null || customer.getEmail() == null){
            return  HttpStatus.UNPROCESSABLE_ENTITY;
        }
        customers.add(tempCustomer);
        return HttpStatus.OK;
    }

    @Override
    public List<Customer> getCustomers() {
        return customers;
    }

    @Override
    public Customer getCustomerByName(String name) {
        for(Customer c : customers){
            if(c.getName().equals(name)){
                return c;
            }
        }
        return new Customer();
    }
}
