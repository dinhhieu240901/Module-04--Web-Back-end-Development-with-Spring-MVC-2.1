package com.example.quanlydanhsachkhachhang.repository;

import com.example.quanlydanhsachkhachhang.bean.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();
    Customer findById(int id);
    void save(Customer customer);
}
