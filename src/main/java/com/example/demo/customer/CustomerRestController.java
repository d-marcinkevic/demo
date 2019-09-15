package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerRestController {

    @Autowired
    CustomerService customerService;

    @PostMapping("api/v1/customers")
    public HttpStatus findCustomerByName(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    @GetMapping("api/v1/customers")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("api/v1/customers/{name}")
    public Customer getCustomerByName(@PathVariable String name){
        return customerService.getCustomerByName(name);
    }
}
