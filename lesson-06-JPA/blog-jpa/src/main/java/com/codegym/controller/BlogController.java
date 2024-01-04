package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ModelAndView showList(){
        List<Blog> blogList = blogService.findAll();
        ModelAndView view = new ModelAndView("index");
        view.addObject("blogs",blogList);
        return view;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView createBlog(@ModelAttribute("blog")Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("redirect:/blogs");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Blog created successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditBlog(@PathVariable Long id){
        ModelAndView view = null;
        Blog blog = blogService.findById(id);
        System.out.println(id);
        if(blog!=null){
            view = new ModelAndView("edit");
            view.addObject("blog",blog);
            return view;
        }
        else {
            view = new ModelAndView("error-404");
            return view;
        }
    }
    @PostMapping("/edit")
    public ModelAndView editBlog(@ModelAttribute("Blog") Blog blog){
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("redirect:/blogs");
        modelAndView.addObject("blog",blog);
        modelAndView.addObject("message","Updated blog successfully");
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteBlog(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        if(blog!=null){
            ModelAndView view = new ModelAndView("delete");
            view.addObject("blog",blog);
            return view;
        }else {
            ModelAndView modelAndView = new ModelAndView("error-404");
            return modelAndView;
        }
    }
    @PostMapping("/delete")
    public ModelAndView deleteBlog(@ModelAttribute("Blog") Blog blog){
        blogService.remove(blog.getId());
        ModelAndView modelAndView = new ModelAndView("redirect:/blogs");
        return modelAndView;
    }
    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("view");
            modelAndView.addObject("blog", blog);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error-404");
            return modelAndView;
        }
    }

}
