package com.example.nasaimageofaday.service;

import com.example.nasaimageofaday.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICommentService  {
    Page<Comment> findAll(Pageable pageable);

    Optional<Comment> findById(Integer id);

    void save(Comment comment) throws Exception;

    void remove(Integer id);
    void like(Integer id);
    void update(Comment comment);


}
