package com.codegym.service.impl;

import com.codegym.model.Customer;
import com.codegym.repository.CustomerRepository;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImplWithSpringData extends CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageInfo) {
        return customerRepository.findAll(pageInfo);
    }

    @Override
    public List<Customer> search(String keyword) {
        Iterable<Customer> searchResult = customerRepository
                .findAllByNameContainsOrEmailContainsOrAddressContains(keyword, keyword, keyword);
        return streamAll(searchResult).collect(Collectors.toList());
    }

    @Override
    public Page<Customer> search(String keyword, Pageable pageInfo) {
        return customerRepository
                .findAllByNameContainsOrEmailContainsOrAddressContains(keyword, keyword, keyword, pageInfo);
    }

    @Override
    protected CrudRepository<Customer, Long> repository() {
        return customerRepository;
    }
}
