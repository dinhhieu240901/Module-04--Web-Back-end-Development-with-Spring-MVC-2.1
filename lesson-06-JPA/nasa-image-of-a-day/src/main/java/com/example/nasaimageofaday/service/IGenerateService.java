package com.example.nasaimageofaday.service;

import java.util.List;

public interface IGenerateService<T> {
    List<T> findAll();
    T findById(int id);
    void save(T t);
    void update(T t);
    void like(int id);

}
