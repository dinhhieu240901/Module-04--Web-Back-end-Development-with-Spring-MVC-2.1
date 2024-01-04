package com.example.nasaimageofaday.controller;

import com.example.nasaimageofaday.model.Comment;
import com.example.nasaimageofaday.service.ICommentService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private ICommentService commentService;
    @GetMapping("")
    public String getAllComments(Model model){
        List<Comment> comments = commentService.findAll();
        model.addAttribute("comments",comments);
        return "index";
    }
    @PostMapping
    public String save(Comment comment){
        commentService.save(comment);
        System.out.println(comment.getId());
        System.out.println(comment.getCommentText());

        return "redirect:/comments";
    }
    @GetMapping("/{id}")
    public String getCommentById(@PathVariable int id,Model model){
        Comment comment = commentService.findById(id);
        model.addAttribute("comment",comment);
        return "comment";
    }
    @PostMapping("/{id}/update")
    public String updateComment(@PathVariable int id, @ModelAttribute Comment comment){
        comment.setId(id);
        commentService.update(comment);
        return "redirect:/comments";
    }
    @PostMapping("/{id}/like")
    public String likeComment(@PathVariable int id) {
        commentService.like(id);
        return "redirect:/comments";
    }

}
