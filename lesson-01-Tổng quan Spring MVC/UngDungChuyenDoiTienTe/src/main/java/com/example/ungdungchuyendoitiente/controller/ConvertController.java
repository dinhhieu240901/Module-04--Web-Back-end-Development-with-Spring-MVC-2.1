package com.example.ungdungchuyendoitiente.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showForm() {
        return "index";
    }
    @RequestMapping(value = "/convert", method = RequestMethod.POST)
    public String convertCurrency(@RequestParam("exchangeRate") double exchangeRate , @RequestParam("usdAmount") double usdAmount, Model model){
        double vndAmount = usdAmount * exchangeRate;
        model.addAttribute("usdAmount", usdAmount);
        model.addAttribute("exchangeRate", exchangeRate);
        model.addAttribute("vndAmount", vndAmount);
        return "result";
    }

}
