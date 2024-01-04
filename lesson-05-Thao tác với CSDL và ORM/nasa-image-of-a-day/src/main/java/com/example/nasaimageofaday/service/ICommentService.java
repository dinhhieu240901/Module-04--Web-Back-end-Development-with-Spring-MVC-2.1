package com.example.nasaimageofaday.service;

import com.example.nasaimageofaday.model.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> findAll();
    void save(Comment comment);
    Comment findById(int id);
    Comment update(Comment comment);
    Comment like(int id);
}
