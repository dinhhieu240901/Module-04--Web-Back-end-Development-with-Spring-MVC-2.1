package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {


    @GetMapping("/index")
    public String index(Customer customer){
        return "index";
    }
}
