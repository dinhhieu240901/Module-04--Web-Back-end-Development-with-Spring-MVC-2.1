package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;

public interface IGenerateService<T> {
    List<T> findAll();
    T findById(Long id);
    void save(T t);
    void remove(Long id);
}
