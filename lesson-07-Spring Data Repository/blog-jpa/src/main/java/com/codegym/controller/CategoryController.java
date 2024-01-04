package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.blog.IBlogService;
import com.codegym.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IBlogService blogService;
    @GetMapping("")
    public ModelAndView showList() {
        Iterable<Category> categoryList = categoryService.findAll();
        ModelAndView view = new ModelAndView("category/index");
        view.addObject("categories", categoryList);
        return view;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("redirect:/categories");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "Category created successfully");
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        if (category != null) {
            ModelAndView modelAndView = new ModelAndView("category/edit");
            modelAndView.addObject("category", category.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error-404");
            return modelAndView;
        }
    }

    @PostMapping("/edit")
    public ModelAndView editCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("redirect:/categories");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "Category updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        if (category != null) {
            ModelAndView modelAndView = new ModelAndView("category/delete");
            modelAndView.addObject("category", category.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error-404");
            return modelAndView;
        }
    }
    @PostMapping("/delete")
    public ModelAndView deleteCategory(@ModelAttribute("category") Category category) {
        categoryService.remove(category.getId());
        ModelAndView modelAndView = new ModelAndView("redirect:/categories");
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewCategory(@PathVariable Long id, Pageable pageable) {
        Optional<Category> category = categoryService.findById(id);
        if (category != null) {
            Page<Blog> blogs = blogService.findByCategory(category, pageable);
            ModelAndView modelAndView = new ModelAndView("category/view");
            modelAndView.addObject("category", category);
            modelAndView.addObject("blogs", blogs);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error-404");
            return modelAndView;
        }
    }



}