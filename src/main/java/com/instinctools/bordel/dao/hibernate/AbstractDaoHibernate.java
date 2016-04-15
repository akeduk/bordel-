package com.instinctools.bordel.dao.hibernate;

import com.instinctools.bordel.dao.GenericDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mack on 04.04.2016.
 */
public abstract class AbstractDaoHibernate<T, PK extends Serializable> implements GenericDao<T, PK> {

    protected Class<T> persistentClass;

    public AbstractDaoHibernate(final Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    public Session getSession() throws HibernateException {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
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
