package com.codegym.repository.impl;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class BlogRepository implements IBlogRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Blog> findAll() {
        String qrFindAll = "SELECT c from Blog as c";
        TypedQuery<Blog> query = entityManager.createQuery(qrFindAll, Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(Long id) {
        String qrFindById = "SELECT c from Blog as c where c.id=:id";
        TypedQuery<Blog> query = entityManager.createQuery(qrFindById, Blog.class);
        query.setParameter("id",id);
        Blog blog;
        try {
            blog = query.getSingleResult();
        }catch (NoResultException e){
             blog = null;
        }

        return blog;
    }

    @Override
    public void save(Blog blog) {
        if(blog.getId()!=null){
            entityManager.merge(blog);
        }else {
            entityManager.persist(blog);
        }
    }

    @Override
    public void remove(Long id) {
        Blog blog = findById(id);
        if(blog!=null){
            entityManager.remove(blog);
        }
    }
}
