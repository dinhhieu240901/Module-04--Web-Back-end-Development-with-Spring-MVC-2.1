package com.example.quanlydanhsachkhachhang.service.impl;

import com.example.quanlydanhsachkhachhang.bean.Customer;
import com.example.quanlydanhsachkhachhang.repository.ICustomerRepository;
import com.example.quanlydanhsachkhachhang.repository.impl.CustomerRepository;
import com.example.quanlydanhsachkhachhang.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service //class level
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository ;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }
}
