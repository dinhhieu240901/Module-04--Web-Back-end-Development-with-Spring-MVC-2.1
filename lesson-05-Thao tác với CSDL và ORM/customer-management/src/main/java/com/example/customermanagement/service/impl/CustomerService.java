package com.example.customermanagement.service.impl;

import com.example.customermanagement.model.Customer;
import com.example.customermanagement.service.ICustomerService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
@Service
public class CustomerService implements ICustomerService {
    public static SessionFactory sessionFactory;
    public static EntityManager entityManager;
    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        }catch (HibernateException e){
            e.printStackTrace();
        }
    }
    @Override
    public List<Customer> findAll() {
        String qrFindAll="SELECT c from Customer as c";
        TypedQuery<Customer> query = entityManager.createQuery(qrFindAll,Customer.class);
        return query.getResultList();
    }

    @Override
    public void save(Customer customer) {
        Session session = null;
        Transaction transaction = null;
        session = sessionFactory.openSession();
        transaction =  session.beginTransaction();
        session.saveOrUpdate(customer);
        transaction.commit();
        session.close();
    }

    @Override
    public Customer findById(int id) {
        String qrFindById = "SELECT c from Customer as c where c.id = :id";
        TypedQuery<Customer> query = entityManager.createQuery(qrFindById,Customer.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void update(Customer customer) {
        Transaction transaction =null;
        Customer origin;
        Session session = null;
        if(customer.getId()==0){
            origin = new Customer();
        }else {
            origin = findById(customer.getId());
        }
        try
        {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            origin.setName(customer.getName());
            origin.setEmail(customer.getEmail());
            origin.setAddress(customer.getAddress());
            session.saveOrUpdate(origin);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            if(transaction != null) transaction.rollback();
        }finally {
            if(session!=null) session.close();
        }
    }

    @Override
    public void remove(int id) {
        Customer customer = findById(id);
        Session session = null;
        if (customer !=null){
            Transaction transaction = null;
            try
            {
                session = sessionFactory.openSession();
                transaction = session.beginTransaction();
                session.delete(customer);
                transaction.commit();
                session.close();
            }catch (Exception e){
                e.printStackTrace();
                if(transaction!=null) transaction.rollback();
            }finally {
                if(session!=null) session.close();
            }
        }
    }
}
