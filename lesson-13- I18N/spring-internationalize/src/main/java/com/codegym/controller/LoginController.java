package com.codegym.controller;

import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping()
    public ModelAndView showLogin(){
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("users",new User());
        return modelAndView;
    }
    @PostMapping("/doLogin")
    public ModelAndView login(@ModelAttribute User user){
        ModelAndView modelAndView = new ModelAndView("success");
        modelAndView.addObject("users",user);
        return modelAndView;

    }
}
