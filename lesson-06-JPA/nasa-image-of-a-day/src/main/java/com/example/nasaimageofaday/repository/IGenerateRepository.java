package com.example.nasaimageofaday.repository;

import java.util.List;

public interface IGenerateRepository<T> {
    List<T> findAll();
    T findById(int id);
    void save(T t);
    void update(T t);
    void like(int id);
}
