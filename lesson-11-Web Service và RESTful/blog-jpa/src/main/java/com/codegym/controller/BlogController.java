//package com.codegym.controller;
//
//import com.codegym.model.Blog;
//import com.codegym.model.Category;
//import com.codegym.service.blog.IBlogService;
//import com.codegym.service.category.ICategoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.Optional;
//
//@RestController
////@RequestMapping("/api/blogs")
//public class BlogController {
//    private final IBlogService blogService;
//
//    private final ICategoryService categoryService;
//@Autowired
//    public BlogController(IBlogService blogService, ICategoryService categoryService) {
//        this.blogService = blogService;
//        this.categoryService = categoryService;
//    }
//
////    @ModelAttribute("categories")
////    public Iterable<Category> listCategory() {
////        return categoryService.findAll();
////    }
//
//    @GetMapping("")
//    public ModelAndView showList(@RequestParam(defaultValue = "0") int page) {
//        //Sort sort = Sort.by(Sort.Order.desc("name"));
//        Sort sort = Sort.by(Sort.Order.asc("name"));
//        //Pageable pageable = PageRequest.of(0, 5, sort); -
//
//        //Phải khởi tạo một param là default nếu không nó bị null
//        Pageable pageable = PageRequest.of(page, 1, sort);
//        //Page<Blog> blogList = blogService.findAllInactiveBlogs(pageable);
//        Page<Blog> blogList = blogService.findAll(pageable);
//
//        ModelAndView view = new ModelAndView("blog/index");
//        view.addObject("blogs", blogList);
//        return view;
//    }
//    @GetMapping("/create")
//    public ModelAndView showCreateForm() {
////        Iterable<Category> categories = categoryService.findAll();
//        ModelAndView modelAndView = new ModelAndView("blog/create");
//        modelAndView.addObject("blog", new Blog());
////        modelAndView.addObject("categories", categories);
//        return modelAndView;
//    }
//
//    @PostMapping("/create")
//    public ModelAndView createBlog(@Validated @ModelAttribute("blog") Blog blog, BindingResult result) {
//        if (result.hasErrors()) {
//            ModelAndView modelAndView = new ModelAndView("blog/create");
//            return modelAndView;
//        }
//        blogService.save(blog);
//        ModelAndView modelAndView = new ModelAndView("redirect:/blogs");
//        modelAndView.addObject("blog", blog);
//        modelAndView.addObject("message", "Blog created successfully");
//        return modelAndView;
//    }
//
//    @GetMapping("/edit/{id}")
//    public ModelAndView showEditForm(@PathVariable Long id) {
//        Optional<Blog> blog = blogService.findById(id);
//        if (blog != null) {
//            Iterable<Category> categories = categoryService.findAll();
//            ModelAndView modelAndView = new ModelAndView("blog/edit");
//            modelAndView.addObject("blog", blog.get());
//            modelAndView.addObject("categories", categories);
//            return modelAndView;
//        } else {
//            ModelAndView modelAndView = new ModelAndView("error-404");
//            return modelAndView;
//        }
//    }
//
//    @PostMapping("/edit")
//    public ModelAndView editBlog(@ModelAttribute("blog") Blog blog) {
//        blogService.save(blog);
//        ModelAndView modelAndView = new ModelAndView("redirect:/blogs");
//        modelAndView.addObject("blog", blog);
//        modelAndView.addObject("message", "Blog updated successfully");
//        return modelAndView;
//    }
//
//    @GetMapping("/delete/{id}")
//    public ModelAndView showDeleteForm(@PathVariable Long id) {
//        Optional<Blog> blog = blogService.findById(id);
//        if (blog != null) {
//            ModelAndView modelAndView = new ModelAndView("blog/delete");
//            modelAndView.addObject("blog", blog.get());
//            return modelAndView;
//        } else {
//            ModelAndView modelAndView = new ModelAndView("error-404");
//            return modelAndView;
//        }
//    }
//
//
//    @PostMapping("/delete")
//    public ModelAndView deleteBlog(@ModelAttribute("blog") Blog blog) {
//        blogService.remove(blog.getId());
//        ModelAndView modelAndView = new ModelAndView("redirect:/blogs");
//        return modelAndView;
//    }
//
//    @GetMapping("/view/{id}")
//    public ModelAndView viewBlog(@PathVariable Long id) {
//        Optional<Blog> blog = blogService.findById(id);
//        if (blog.isPresent()) {
//            ModelAndView modelAndView = new ModelAndView("blog/view");
//            modelAndView.addObject("blog", blog.get());
//            return modelAndView;
//        } else {
//            ModelAndView modelAndView = new ModelAndView("error-404");
//            return modelAndView;
//        }
//    }
//    @GetMapping("/search")
//    public ModelAndView search(@RequestParam("search") String name){
//        Iterable<Blog> blogList = blogService.findByNameContaining(name.trim());
//        ModelAndView view = new ModelAndView("blog/index");
//        view.addObject("blogs",blogList);
//        return view;
//    }
//    @GetMapping("/category/{categoryId}")
//    public ModelAndView  showListCategory(@PathVariable Long categoryId){
//        Optional<Category> category = categoryService.findById(categoryId);
//        if(category == null){
//            ModelAndView errorView = new ModelAndView("error-404");
//            return errorView;
//        }
//        Sort sort = Sort.by(Sort.Order.asc("name"));
//        Pageable pageable = PageRequest.of(0, 1, sort);
//        Page<Blog> blogList = blogService.findByCategory(category.get(), pageable);
//        ModelAndView view = new ModelAndView("blog/index");
//        view.addObject("blogs", blogList);
//        view.addObject("selectedCategory", category.get());
//        return view;
//    }
//
//}
