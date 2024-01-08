package com.codegym.controller;

import com.codegym.model.Cart;
import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {

    private IProductService productService;
    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }
    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @ModelAttribute Cart cart,
                            @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "error_404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }

        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }
    @GetMapping("/delete/{id}")
    public String removeFromCart(@PathVariable Integer id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "error_404";
        }
        if (action.equals("show")) {
            cart.removeProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.removeProduct(productOptional.get());
        return "redirect:/shop";
    }
    @GetMapping("/view-product/{id}")
    public ModelAndView viewProduct(@PathVariable Long id,
                                    @ModelAttribute Cart cart) {
        ModelAndView modelAndView = new ModelAndView("view-product");
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            modelAndView.addObject("product", productOptional.get());
            modelAndView.addObject("quantityInCart", cart.getProductQuantity(productOptional.get()));
        } else {
            modelAndView.setViewName("error_404");
        }
        return modelAndView;
    }
    @PostMapping("/update-cart/{id}")
    public String updateCart(@PathVariable Long id,
                             @RequestParam Integer quantity,
                             @ModelAttribute Cart cart) {

        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            cart.updateProductQuantity(productOptional.get(), quantity);
        }

        return "redirect:/shopping-cart";
    }
    @GetMapping ("/delete_all/{id}")
    public String deleteFromCart(@PathVariable Long id, @ModelAttribute Cart cart) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            cart.deleteProduct(product);
        }
        return "redirect:/shopping-cart";
    }
}
