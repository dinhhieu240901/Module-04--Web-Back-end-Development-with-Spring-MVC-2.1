package com.example.healdeclaraionform.controller;


import com.example.healdeclaraionform.model.HealDeclaration;
import com.example.healdeclaraionform.service.IHealthDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/form")
public class HealDeclarationController {
    @Autowired
    private IHealthDeclarationService healthDeclarationService;
    @GetMapping("/show")
    public String showForm(Model model) {
        model.addAttribute("healDeclaration", healthDeclarationService.get());
        return "healthDeclarationForm";
    }

    @PostMapping("/submit")
    public String submitForm(HealDeclaration submittedDeclaration, Model model) {
        System.out.println("Submit Form Called");
        healthDeclarationService.update(submittedDeclaration);
        model.addAttribute("healDeclaration",submittedDeclaration);
        model.addAttribute("success", "Đã gửi tờ khai thành công");
        return "healthDeclarationConfirmation";
    }
    @GetMapping("/view")
    public String viewDeclaration(Model model) {
        model.addAttribute("healDeclaration", new HealDeclaration());
        return "viewHealthDeclaration";
    }
}
