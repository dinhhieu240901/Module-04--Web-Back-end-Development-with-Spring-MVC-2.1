package com.example.quanlydanhsachkhachhang.repository.impl;

import com.example.quanlydanhsachkhachhang.bean.Customer;
import com.example.quanlydanhsachkhachhang.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class CustomerRepository implements ICustomerRepository {

    private static Map<Integer,Customer> customers ;
    protected CustomerRepository(){
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "Mai Thy", "thy@gmail.com","Phú Yên"));
        customers.put(2, new Customer(2, "Đình Hiếu", "hieu@gmail.com","Đồng Nai"));
        customers.put(3, new Customer(3, "Thanh Thảo", "thao@gmail.com", "Bình Dương"));
        customers.put(4, new Customer(4, "Nguyen Thi Mai", "mai@gmail.com", "Sài Gòn"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(), customer);
    }
}