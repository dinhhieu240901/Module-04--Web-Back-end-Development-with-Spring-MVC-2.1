package com.example.quanlydanhsachkhachhang.controller;
import com.example.quanlydanhsachkhachhang.bean.Customer;
import com.example.quanlydanhsachkhachhang.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("/list")
    private String showCustomer(Model model){
        model.addAttribute("listCustomer",customerService.findAll());
        return "customers/list";
    }
    @GetMapping("/view/{id}")
    public ModelAndView viewCustomer(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("customers/view");
        Customer customer = customerService.findById(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }
    @GetMapping("/add")
    public String showAddCustomer(Model model){
        model.addAttribute("customer",new Customer());
        return "/customers/add";
    }
    @PostMapping("/add")
    public String addCustomer(@ModelAttribute Customer  customer, RedirectAttributes redirectAttributes, HttpServletRequest request) throws UnsupportedEncodingException {
       request.setCharacterEncoding("UTF-8");
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "Added customer successfully!");
        return "redirect:/list";
    }
}
