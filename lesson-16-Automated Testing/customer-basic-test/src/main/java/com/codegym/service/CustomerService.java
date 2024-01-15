package com.codegym.service;

import com.codegym.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements ICustomerService{
    private static final List<Customer> customers;

    static {
        customers = new ArrayList<>();
        customers.add(new Customer(1, "Hoang", "Kien"));
        customers.add(new Customer(2, "Lam", "Thai"));
    }
    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer add(Customer customer) {
        customers.add(customer);
        return customer;
    }

    @Override
    public Customer findById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }
}
