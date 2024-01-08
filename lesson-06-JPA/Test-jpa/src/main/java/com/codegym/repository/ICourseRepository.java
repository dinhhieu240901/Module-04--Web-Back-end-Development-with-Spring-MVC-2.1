package com.codegym.repository;

import com.codegym.enitity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepository extends JpaRepository<Course ,Integer> {
}
