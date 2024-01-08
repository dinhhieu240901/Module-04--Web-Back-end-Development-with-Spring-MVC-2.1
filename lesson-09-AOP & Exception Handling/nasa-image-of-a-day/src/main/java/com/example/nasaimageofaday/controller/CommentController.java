package com.example.nasaimageofaday.controller;

import com.example.nasaimageofaday.model.Comment;
import com.example.nasaimageofaday.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/comments")
public class CommentController {

    private final ICommentService commentService;
    @Autowired
    public CommentController(ICommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("")
    public String getAllComments(@PageableDefault(size = 5) Pageable pageable, Model model){
        Page<Comment> comments = commentService.findAll(pageable);
        model.addAttribute("comments", comments);
        return "index";
    }
    @PostMapping
    public String save(Comment comment,Model model) throws Exception{
        try {
            commentService.save(comment);
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        System.out.println(comment.getId());
        System.out.println(comment.getCommentText());
        return "redirect:/comments";
    }

    @GetMapping("/{id}")
    public String getCommentById(@PathVariable int id, Model model) {
        Optional<Comment> comment = commentService.findById(id);
        model.addAttribute("comment", comment);
        return "comment";
    }
    @PostMapping("/{id}/update")
    public String updateComment(@PathVariable int id, @ModelAttribute Comment comment){
        comment.setId(id);
        commentService.update(comment);
        return "redirect:/comments";
    }


    @PostMapping("/{id}/like")
    public String likeComment(@PathVariable int id, Pageable pageable) {
        commentService.like(id);
        return "redirect:/comments";
    }
}