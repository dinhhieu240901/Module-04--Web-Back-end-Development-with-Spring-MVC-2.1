package com.codegym.service;

import com.codegym.enitity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceCategory {
    List<Category> findAll();
}
