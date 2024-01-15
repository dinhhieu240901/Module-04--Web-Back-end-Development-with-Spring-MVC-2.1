package com.codegym.service.blog;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService implements IBlogService {

    private final IBlogRepository blogRepository;
    @Autowired
    public BlogService(IBlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }


    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

//    @Override
//    public Page<Blog> findAll(Pageable pageable, Sort sort) {
//        return blogRepository.findAll(pageable,sort);
//    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }



    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findByCategory(Optional<Category> category, Pageable pageable) {
        return blogRepository.findByCategory(category, pageable);
    }

//    @Override
//    public Page<Blog> findByNameContaining(Pageable pageable, String name) {
//        return blogRepository.findByNameContaining(pageable,name);
//    }
//
    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return  blogRepository.findAll(pageable);
    }

    @Override
    public Iterable<Blog> findByNameContaining(String name) {
        return blogRepository.findByNameContaining(name);
    }

    @Override
    public Iterable<Blog> findAllSorted(Sort sort) {
        return blogRepository.findAll(sort);
    }

    @Override
    public Page<Blog> findByCategory(Category category, Pageable pageable) {
        return blogRepository.findByCategory(category,pageable);
    }


}
