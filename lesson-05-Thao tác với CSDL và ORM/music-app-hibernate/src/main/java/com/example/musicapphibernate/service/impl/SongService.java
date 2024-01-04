package com.example.musicapphibernate.service.impl;

import com.example.musicapphibernate.model.Song;
import com.example.musicapphibernate.service.ISongService;
import com.example.musicapphibernate.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class SongService implements ISongService {
    @Override
    public List<Song> findAll() {
        String qrFindAll = "SELECT c from Song as c";
        TypedQuery<Song> query = HibernateUtil.entityManager.createQuery(qrFindAll, Song.class);
        return query.getResultList();
    }

    @Override
    public Song findById(int id) {
        String qrFindById = "SELECT c from Song as c where c.id =:id";
        TypedQuery<Song> query = HibernateUtil.entityManager.createQuery(qrFindById, Song.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void save(Song song) {
        Transaction transaction = null;
        Song origin;
        Session session = null;
        if (song.getId() == 0) {
            origin = new Song();
        } else {
            origin = findById(song.getId());
        }
        // Update the fields of origin with the values from song
        origin.setName(song.getName());
        origin.setArtist(song.getArtist());
        origin.setGenre(song.getGenre());
        origin.setFilePath(song.getFilePath());
        try {
            session = HibernateUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(origin);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) session.close();
        }
    }


    @Override
    public void remove(int id) {
        Song song = findById(id);
        if (song != null) {
            Transaction transaction = null;
            try (Session session = HibernateUtil.sessionFactory.openSession()) {
                transaction = session.beginTransaction();
                session.delete(song);
                transaction.commit();
                session.close();
            } catch (Exception e) {
                e.printStackTrace();
                if (transaction != null) transaction.rollback();
            }
        }
    }
}
