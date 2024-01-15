package com.codegym.controller;

import com.codegym.security.SecurityConfiguration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class SecurityController {
    private String getPrinciple(){
        String username;
        Object principle = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principle instanceof UserDetails){
            username = ((UserDetails) principle).getUsername();
        }
        else {
            username= principle.toString();
        }
        return username;
    }
    @GetMapping(value = {"/", "/home"})
    public String HomePage(Model model){
        model.addAttribute("user",getPrinciple());
        return "welcome";
    }
    @GetMapping("/admin")
    public String adminPage(Model model){
        model.addAttribute("user",getPrinciple());
        return "admin";
    }
    @GetMapping("/accessDenied")
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrinciple());
        return "access_denied";
    }
    @GetMapping( "/dba")
    public String dbaPage(ModelMap model) {
        model.addAttribute("user", getPrinciple());
        return "dba";
    }
}
