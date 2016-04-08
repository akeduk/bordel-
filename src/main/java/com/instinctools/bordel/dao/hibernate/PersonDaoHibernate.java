package com.instinctools.bordel.dao.hibernate;

import com.instinctools.bordel.dao.PersonDao;
import com.instinctools.bordel.model.Client;
import com.instinctools.bordel.model.Person;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Abstract DAO for person
 */
public abstract class PersonDaoHibernate<T extends Person> extends AbstractDaoHibernate<T, Long> implements PersonDao<T> {

    public PersonDaoHibernate(Class<T> persistentClass) {
        super(persistentClass);
    }

    public List<T> getByName(String name) {
        Criteria cr = getSession().createCriteria(super.persistentClass);
        cr.add(Restrictions.eq("name", name));

        return (List<T>)cr.list();
    }
}
