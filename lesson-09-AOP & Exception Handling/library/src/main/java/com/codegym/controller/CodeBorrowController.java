package com.codegym.controller;

import com.codegym.exception.NotAvailableException;
import com.codegym.exception.WrongCodeException;
import com.codegym.model.Book;
import com.codegym.model.Code;

import com.codegym.service.IBookService;
import com.codegym.service.ICodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/code-borrow")
public class CodeBorrowController {

    private final IBookService bookService;
    private final ICodeService codeService;
    @Autowired
    public CodeBorrowController(IBookService bookService, ICodeService codeService) {
        this.bookService = bookService;
        this.codeService = codeService;
    }

    @GetMapping("/{bookId}")
    public String showCodeBorrowList(@PathVariable Long bookId, Model model) {
        List<Code> allCodes = codeService.findAllCodesByBookId(bookId);
        model.addAttribute("allCodes", allCodes);
        return "code-borrow-list";
    }
}