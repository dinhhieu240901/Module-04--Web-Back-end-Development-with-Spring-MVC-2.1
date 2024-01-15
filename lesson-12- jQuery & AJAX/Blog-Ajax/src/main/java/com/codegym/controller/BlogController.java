package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.blog.IBlogService;
import com.codegym.service.category.ICategoryService;
import com.google.protobuf.ApiProto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/blogs")
public class BlogController {
    private IBlogService blogService;
    private ICategoryService categoryService;
    @Autowired
    public BlogController(IBlogService blogService,ICategoryService categoryService) {
        this.blogService = blogService;
        this.categoryService=categoryService;
    }
    @ModelAttribute("categories")
    private Iterable<Category> categories() {
        return categoryService.findAll();
    }
    @GetMapping
    private ResponseEntity<Iterable<Blog>> findAllBlog(){
        List<Blog> blogs = (List<Blog>) blogService.loadMoreBlogs(0,20);
        if(blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    private ResponseEntity<Blog> findById(@PathVariable Long id){
     Optional<Blog> blogOptional = blogService.findById(id);
     if(!blogOptional.isPresent()){
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
     return new ResponseEntity<>(blogOptional.get(),HttpStatus.OK);
    }
    @PostMapping()
    private ResponseEntity<Blog> saveBlog(@RequestBody Blog blog){
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    private ResponseEntity<Blog> removeBlog(@PathVariable Long id){
        Optional<Blog> blogOptional = blogService.findById(id);
        if(!blogOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
      blogService.remove(id);
        return new ResponseEntity<>(blogOptional.get(),HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Blog> updateBlog(@PathVariable Long id, @RequestBody Blog blog){
        Optional<Blog> blogOptional = blogService.findById(id);
        if(!blogOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setId(blogOptional.get().getId());
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<Iterable<Blog>> searchBlogs(@RequestParam String keyword) {
        Iterable<Blog> blogsList = blogService.findByTitleContaining(keyword);
        List<Blog> blogs = (List<Blog>) blogsList;

        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
    @GetMapping("/loadMore")
    public ResponseEntity<Iterable<Blog>> loadMoreBlogs(@RequestParam int page) {
        Iterable<Blog> blogsList = blogService.loadMoreBlogs(page, 20);
        List<Blog> blogs = (List<Blog>) blogsList;

        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}
