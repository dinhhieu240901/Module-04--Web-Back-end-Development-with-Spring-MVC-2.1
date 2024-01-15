package com.codegym.repository;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Long> {
    Iterable<Blog> findAllByCategory(Category category);
    List<Blog> findByNameContaining(String name);
}
