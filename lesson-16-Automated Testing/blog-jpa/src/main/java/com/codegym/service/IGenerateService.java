package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface IGenerateService<T> {
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    void save(T t);
    void remove(Long id);
}
