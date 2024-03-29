package com.codegym.repository;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IBlogRepository extends CrudRepository<Blog,Long> {
        Page<Blog> findAll(Pageable pageable);
        Iterable<Blog> findAll(Sort sort);


        Page<Blog> findByCategory(Optional<Category> category, Pageable pageable);

        Page<Blog> findByCategory(Category category, Pageable pageable);

        Iterable<Blog> findByNameContaining(String name);

}
