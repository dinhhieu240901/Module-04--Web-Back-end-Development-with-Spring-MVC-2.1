package com.example.sandwichcondiments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class SandwichController {
    @GetMapping("/sandwich")
    public ModelAndView showIndex() {
        ModelAndView modelAndView = new ModelAndView("sandwich");
        return modelAndView;
    }
    @PostMapping("/sandwich")
    public String save(@RequestParam("condiment") String[] condiment, Model choose, Model show) {
        String a = "";
        String b = "You want to add:";
        for(String i : condiment){
            a += i;
        }
        choose.addAttribute("selectCondiment", a);
        show.addAttribute("showCondiment", b);
        return "sandwich";
    }
}



