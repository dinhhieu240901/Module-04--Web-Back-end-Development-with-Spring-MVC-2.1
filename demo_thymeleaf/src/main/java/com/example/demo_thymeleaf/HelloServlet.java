package com.example.demo_thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServlet;

@Controller
public class HelloServlet extends HttpServlet {
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("message", "Xin chào, đâylà ứng dụng web Thymeleaf!");
        return "/index";
    }
}