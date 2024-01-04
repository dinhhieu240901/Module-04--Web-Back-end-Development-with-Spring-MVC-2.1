package com.example.nasaimageofaday.service.impl;

import com.example.nasaimageofaday.model.Comment;
import com.example.nasaimageofaday.repository.ICommentRepository;
import com.example.nasaimageofaday.service.ICommentService;
import com.example.nasaimageofaday.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import java.util.List;
@Service
public class CommentService implements ICommentService {
    @Autowired
    ICommentRepository commentRepository;
    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(int id) {
        return commentRepository.findById(id);
    }

    @Override
    public void save(Comment comment) {
         commentRepository.save(comment);
    }

    @Override
    public void update(Comment comment) {
        commentRepository.update(comment);
    }

    @Override
    public void like(int id) {
        commentRepository.like(id);
    }
}