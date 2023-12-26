package com.example.demospringmvc.service;

import com.example.demospringmvc.bean.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
}
