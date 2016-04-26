package com.instinctools.bordel.dao.hibernate;

import com.instinctools.bordel.dao.GenericDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by mack on 04.04.2016.
 */
public abstract class AbstractDaoHibernate<T, PK extends Serializable> implements GenericDao<T, PK> {

    protected Class<T> persistentClass;

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public AbstractDaoHibernate(final Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    public Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }

    public List<T> getAll() {
        return getSession().createCriteria(persistentClass).list();
    }

    public T get(PK id) {
        return getSession().byId(persistentClass).load(id);
    }

    public T save(T object) {
        return (T) getSession().merge(object);
    }

    public void remove(T object) {
        getSession().delete(object);
    }
}
