package com.example.demospringmvc.controller;

import com.example.demospringmvc.repository.IStudentRepository;
import com.example.demospringmvc.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService ;
    @GetMapping(value = "")
    public String getPage(Model model){
        //Dùng model để gửi dữ liệu
        model.addAttribute("name","Chào mừng C0823H1");
        return "student";
    }
    @GetMapping(value = "list")
    public String getList(Model model){
        //Dùng model để gửi dữ liệu
        model.addAttribute("studentList",studentService.findAll());
        return "list";
    }
}
