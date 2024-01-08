package com.codegym.controller;

import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/user")
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }
    @PostMapping("/validate")
    public ModelAndView validate(@Validated @ModelAttribute("user") User user, BindingResult result){
        if(result.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("/index");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("/result");
        return modelAndView;
    }
}
