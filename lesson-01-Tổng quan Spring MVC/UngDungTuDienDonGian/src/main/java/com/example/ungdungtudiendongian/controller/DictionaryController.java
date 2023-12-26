package com.example.ungdungtudiendongian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    private Map<String, String> dictionary = new HashMap<>();
    public DictionaryController() {
        dictionary.put("hello", "xin chào");
        dictionary.put("how", "thế nào");
        dictionary.put("book", "quyển sách");
        dictionary.put("computer", "máy tính");
    }
    @RequestMapping("/home")
    public String home() {
        return "index";
    }

    @RequestMapping("/search")
    public String search(@RequestParam("txtSearch") String enWord, Model model) {
        String vnWord = dictionary.get(enWord);
        model.addAttribute("word", enWord);
        if (vnWord != null) {
            model.addAttribute("mean", vnWord);
            return "word";
        } else {
            return "notfound";
        }
    }
}
