package com.example.quanlydanhsachkhachhang.service;

import com.example.quanlydanhsachkhachhang.bean.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer findById(int id);
    void save(Customer customer);
}
