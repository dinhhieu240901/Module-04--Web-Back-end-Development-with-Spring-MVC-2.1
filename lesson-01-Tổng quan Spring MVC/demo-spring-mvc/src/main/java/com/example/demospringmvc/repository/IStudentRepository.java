package com.example.demospringmvc.repository;

import com.example.demospringmvc.bean.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
}
