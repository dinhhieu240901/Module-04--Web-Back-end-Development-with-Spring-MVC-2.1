package com.example.nasaimageofaday.repository.impl;

import com.example.nasaimageofaday.model.Comment;
import com.example.nasaimageofaday.repository.ICommentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CommentRepository implements ICommentRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Comment> findAll() {
        return em.createQuery("SELECT c from Comment c", Comment.class).getResultList();
    }

    @Override
    public Comment findById(int id) {
        return em.find(Comment.class, id);
    }

    @Override
    public void save(Comment comment) {
        if (comment.getId() == 0) {
            em.persist(comment);
        } else {
            em.merge(comment);
        }
    }

    @Override
    public void update(Comment comment) {
        Comment origin = findById(comment.getId());
        if (origin != null) {
            em.merge(comment);
        }
    }

    @Override
    public void like(int id) {
        Comment comment = findById(id);
        if (comment != null) {
            comment.setLikes(comment.getLikes() + 1);
            em.merge(comment);
        }
    }
}
