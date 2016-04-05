package com.instinctools.bordel.dao.hibernate;

import com.instinctools.bordel.dao.PersonDao;
import com.instinctools.bordel.model.Person;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by mack on 05.04.2016.
 */
public abstract class PersonDaoHibernate<T extends Person> extends AbstractDaoHibernate<T, Long> implements PersonDao<T> {

    private Class<T> persistenceClass;

    public PersonDaoHibernate(Class<T> persistentClass) {
        super(persistentClass);
        this.persistenceClass = super.persistentClass;
    }

    public List<T> getByName(String name) {
        Criteria cr = getSession().createCriteria(persistenceClass);
        cr.add(Restrictions.eq("name", name));

        return cr.list();
    }
}
