package com.groupeisi.securiteweb.dto;

import com.groupeisi.securiteweb.interfaces.Repository;
import com.groupeisi.securiteweb.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RepositoryDAO<T> implements Repository<T> {
    protected Session session;
    protected Transaction transaction;
    public RepositoryDAO(){
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public int add(T t) {
        transaction = session.beginTransaction();
        session.save(t);
        transaction.commit();
        return 1;
    }

    @Override
    public int update(T t) {
        transaction = session.beginTransaction();
        session.merge(t);
        transaction.commit();
        return 1;
    }

    @Override
    public int delete(int id, T t) {
        transaction = session.beginTransaction();
        session.delete(session.get(t.getClass(), id));
        transaction.commit();
        return 1;
    }

    @Override
    public List<T> list(T t) {
        return (List<T>) session.createCriteria(t.getClass()).list();
    }

    @Override
    public T get(int id, T t) {
        return (T) session.get(t.getClass(), id);
    }
}
