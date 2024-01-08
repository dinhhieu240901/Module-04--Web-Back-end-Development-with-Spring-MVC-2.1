package com.codegym.controller;

import com.codegym.model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PhoneController {
    @GetMapping("/phone")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("phoneNumber",new PhoneNumber());
        return modelAndView;
    }
    @PostMapping("/validate")
    public ModelAndView validate(@Valid @ModelAttribute("phoneNumber")PhoneNumber phoneNumber, BindingResult result){
      new PhoneNumber().validate(phoneNumber,result);
      if(result.hasFieldErrors()){
          ModelAndView modelAndView = new ModelAndView("index");
          return modelAndView;
      }else {
          ModelAndView modelAndView =new ModelAndView("result");
          modelAndView.addObject("phoneNumber",phoneNumber);
          return modelAndView;
      }
    }
}
