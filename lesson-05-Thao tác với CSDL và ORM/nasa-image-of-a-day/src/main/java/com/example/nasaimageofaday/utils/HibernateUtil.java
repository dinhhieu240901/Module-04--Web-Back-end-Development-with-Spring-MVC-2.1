package com.example.nasaimageofaday.utils;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;

public class HibernateUtil {
    public static SessionFactory sessionFactory;
    public static EntityManager entityManager;
     static {
             try {
                 sessionFactory = new Configuration().configure("hibernate-config.xml").buildSessionFactory();
                 entityManager = sessionFactory.createEntityManager();
             }catch (HibernateException e){
                 e.printStackTrace();
             }
         }
     }


