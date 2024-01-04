package com.example.nasaimageofaday.service.impl;

import com.example.nasaimageofaday.model.Comment;
import com.example.nasaimageofaday.repository.ICommentRepository;
import com.example.nasaimageofaday.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService implements ICommentService {
    @Autowired
    ICommentRepository commentRepository;

    @Override
    public Page<Comment> findAll(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }

    @Override
    public Optional<Comment> findById(Integer id) {
        return commentRepository.findById(id);
    }

    @Override
    public void save(Comment image) {
        commentRepository.save(image);
    }

    @Override
    public void remove(Integer id) {
        commentRepository.deleteById(id);
    }
    @Override
    public void like(Integer id) {
        Optional<Comment> commentOptional = commentRepository.findById(id);
        if (commentOptional.isPresent()) {
            Comment comment = commentOptional.get();
            Integer likes = comment.getLikes();
            if (likes == null) {
                likes = 0;
            }
            comment.setLikes(likes + 1);
            commentRepository.save(comment);
        }
    }
    @Override
    public void update(Comment comment) {
        commentRepository.save(comment);
    }
}