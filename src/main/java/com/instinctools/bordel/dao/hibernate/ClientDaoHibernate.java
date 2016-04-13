package com.instinctools.bordel.dao.hibernate;

import com.instinctools.bordel.dao.ClientDao;
import com.instinctools.bordel.model.Client;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import java.util.Calendar;
import java.util.List;

/**
 * Created by mack on 04.04.2016.
 */
public class ClientDaoHibernate extends PersonDaoHibernate<Client> implements ClientDao {

    public ClientDaoHibernate(Class<Client> persistentClass) {
        super(persistentClass);
    }

    public List<Client> getByPreferences(final String preferences) {
        Criteria cr = getSession().createCriteria(Client.class);
        cr.add(Restrictions.like("preferences", preferences, MatchMode.ANYWHERE));

        return (List<Client>)cr.list();
    }

    public List<Client> getByBirthday(final Calendar from, Calendar to) {
        Criteria cr = getSession().createCriteria(Client.class);
        cr.add(Restrictions.between("birthday", from, to));

        return (List<Client>) cr.list();
    }
}
