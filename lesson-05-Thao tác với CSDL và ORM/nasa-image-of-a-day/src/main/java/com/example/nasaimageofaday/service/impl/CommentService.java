package com.example.nasaimageofaday.service.impl;

import com.example.nasaimageofaday.model.Comment;
import com.example.nasaimageofaday.service.ICommentService;
import com.example.nasaimageofaday.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import java.util.List;
@Service
public class CommentService implements ICommentService {
    @Override
    public List<Comment> findAll() {
        String qrFindAll = "SELECT c from Comment as c";
        TypedQuery<Comment> query = HibernateUtil.entityManager.createQuery(qrFindAll,Comment.class);
        return query.getResultList();
    }

    @Override
    public void save(Comment comment) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            comment.setLikes(0);
            comment.setAuthorName(comment.getAuthorName());
            comment.setCommentText(comment.getCommentText());
            session.saveOrUpdate(comment);
            transaction.commit();
        } catch (Exception e){
            if(transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
    @Override
    public Comment findById(int id) {
        String qrFindById = "SELECT c from Comment as c where c.id =:id";
        TypedQuery<Comment> query = HibernateUtil.entityManager.createQuery(qrFindById,Comment.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public Comment update(Comment comment) {
        Transaction transaction = null;
        Comment origin;
        try (Session session = HibernateUtil.sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            origin = findById(comment.getId());
            if (origin != null) {
                origin.setCommentText(comment.getCommentText());
                origin.setAuthorName(comment.getAuthorName());
                origin.setRating(comment.getRating());
                session.saveOrUpdate(origin);
                transaction.commit();
                return origin;
            }
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Comment like(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Comment comment = findById(id);
            if (comment != null) {
                comment.setLikes(comment.getLikes()+1);
                session.saveOrUpdate(comment);
                transaction.commit();
                return comment;
            }
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
        return null;
    }
}