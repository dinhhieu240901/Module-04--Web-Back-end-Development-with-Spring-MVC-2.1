package com.example.calculator2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class CalculateController {
    @GetMapping("/calculate")
    public String showCalculator(){
        return "calculator";
    }
    @PostMapping("/calculate")
    public String calculate(@RequestParam("number1") int number1,
                            @RequestParam("number2") int number2,
                            @RequestParam("operation") String operation,
                            Model model) {
        int result = 0;
        switch (operation) {
            case "add":
                result = number1 + number2;
                break;
            case "subtract":
                result = number1 - number2;
                break;
            case "multiply":
                result = number1 * number2;
                break;
            case "divide":
                result = number1 / number2;
                break;
        }
        model.addAttribute("result", result);
        return "calculator";
    }
}
