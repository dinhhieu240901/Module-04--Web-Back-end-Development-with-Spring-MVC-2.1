package com.codegym.controller;

import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class UserController {


    @ModelAttribute("user")
    public User createUser() {
        return new User(); // tạo một đối tượng user và thêm vào model với key "user"
    }

    @GetMapping(value = "/login")
    public String login(@CookieValue(value = "username", defaultValue = "") String username, Model model) {
        model.addAttribute("username", username);
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(User user, Model model, @CookieValue(value = "username", defaultValue = "") String username, HttpServletResponse response, HttpServletRequest request) {
        if (user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
            if (user.getUsername() != null) {
                username = user.getUsername();
            }
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60 * 60 * 24);
            response.addCookie(cookie);
            Cookie[] cookies = request.getCookies();
            for (Cookie ck : cookies
            ) {
                if (!ck.getName().equals("username")) {
                    ck.setValue("");
                }
                model.addAttribute("cookieValue", ck);
            }
            model.addAttribute("message", "Login success. Welcome!");
        }else {
            user.setUsername("");
            Cookie cookie = new Cookie("username",username);
            model.addAttribute("cookieValue",cookie);
            model.addAttribute("message","Login failed,try again");
        }
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("username", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/login";
    }
}
