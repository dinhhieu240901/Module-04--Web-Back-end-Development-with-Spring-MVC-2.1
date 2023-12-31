package com.example.emailconfiguration.controller;

import com.example.emailconfiguration.model.EmailSettings;
import com.example.emailconfiguration.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/email")
public class EmailController {
    @Autowired
    IEmailService emailService;
    @GetMapping("/list")
    public String displayAll(Model model){
        List<EmailSettings> emailList = emailService.findAll();
        model.addAttribute("emailList",emailList);
        return "list";
    }
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model){
        EmailSettings emailSettings= emailService.findById(id);
        model.addAttribute("email",emailSettings);
        model.addAttribute("languageList",emailService.languageList());
        model.addAttribute("pageSizeList",emailService.pageSize());
        return "edit";
    }
    @PostMapping("/edit")
    public String editSubmit(@ModelAttribute EmailSettings email,Model model){
        emailService.edit(email);
        List<EmailSettings> emailList = emailService.findAll();
        model.addAttribute("emailList",emailList);
        return "list";
    }
}
