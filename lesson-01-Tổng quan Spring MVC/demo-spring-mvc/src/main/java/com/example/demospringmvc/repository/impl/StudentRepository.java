package com.example.demospringmvc.repository.impl;

import com.example.demospringmvc.bean.Student;
import com.example.demospringmvc.repository.IStudentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class StudentRepository implements IStudentRepository {

    private Map<Integer, Student> studentData;

    public StudentRepository() {
        studentData = new HashMap<>();
        // Tạo dữ liệu giả
        studentData.put(1, new Student(1, "Mai Thy", "1998-01-01"));
        studentData.put(2, new Student(2, "Đình Hiếu", "2001-02-02"));
        studentData.put(3, new Student(3, "Le Quang Huy", "1992-03-03"));
        studentData.put(4, new Student(4, "Pham Bao Ngoc", "1993-04-04"));
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentData.values());
    }
}
