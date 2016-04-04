package com.instinctools.bordel.dao.hibernate;

import com.instinctools.bordel.model.Client;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by mack on 04.04.2016.
 */
public class ClientDaoHibernate extends AbstractDaoHibernate<Client, Long> implements ClientDao {

    public ClientDaoHibernate(Class<Client> persistentClass) {
        super(persistentClass);
    }

    public List<Client> getByPreferences(String preferences) {
        Criteria cr = getSession().createCriteria(Client.class);
        cr.add(Restrictions.like("preferences", preferences, MatchMode.ANYWHERE));
        return cr.list();
    }
}
