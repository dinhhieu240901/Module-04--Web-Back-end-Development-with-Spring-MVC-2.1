package com.example.customermanagement.controller;

import com.example.customermanagement.model.Customer;
import com.example.customermanagement.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("")
    public String index(Model model){
        List<Customer> customers = customerService.findAll();
        model.addAttribute("listCustomer",customers);
        return "index";
    }
    @GetMapping("/{id}/detail")
    public String detailCustomer(@PathVariable int id, Model model){
        Customer customer = customerService.findById(id);
        model.addAttribute("customer",customer);
        return "detail";
    }
    @GetMapping("/create")
    public String create(Model model) {
        Customer customer = new Customer();

        model.addAttribute("customer", customer);
        return "/create";
    }

    @PostMapping("/create")
    public String save(Customer customer,RedirectAttributes rs) {
        customerService.save(customer);
        rs.addFlashAttribute("validate","Added customer successfully");
        return "redirect:/customers";
    }
    @GetMapping("/{id}/edit")
    public String showUpdate(@PathVariable int id, Model model){
        Customer customer = customerService.findById(id);
        model.addAttribute("customer",customer);
        return "update";
    }
    @PostMapping("/update")
    public String update(Customer customer, RedirectAttributes rs){
        customerService.update(customer);
        rs.addFlashAttribute("validate","Updated customer successfully");
        return "redirect:/customers";
    }
    @GetMapping("/{id}/delete")
    public String showDelete(@PathVariable int id, Model model){
        Customer customer = customerService.findById(id);
        model.addAttribute("customer",customer);
        return "delete";
    }
    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes rs){
        customerService.remove(customer.getId());
        rs.addFlashAttribute("validate","Updated customer successfully");
        return "redirect:/customers";
    }
}
