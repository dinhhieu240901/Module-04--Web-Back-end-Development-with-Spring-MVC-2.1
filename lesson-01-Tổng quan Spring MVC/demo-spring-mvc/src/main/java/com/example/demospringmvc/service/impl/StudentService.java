package com.example.demospringmvc.service.impl;

import com.example.demospringmvc.bean.Student;
import com.example.demospringmvc.repository.IStudentRepository;
import com.example.demospringmvc.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
