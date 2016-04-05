package com.instinctools.bordel.dao.hibernate;

import com.instinctools.bordel.dao.ServiceDao;
import com.instinctools.bordel.model.Employee;
import com.instinctools.bordel.model.Service;
import com.instinctools.bordel.model.Status;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.Calendar;
import java.util.List;

/**
 * Created by mack on 05.04.2016.
 */
public class ServiceDaoHibernate extends AbstractDaoHibernate<Service, Long> implements ServiceDao {

    public ServiceDaoHibernate(Class<Service> persistentClass) {
        super(persistentClass);
    }

    public List<Service> getByEmployee(Employee employee, Calendar dateFrom, Calendar dateTo) {
        Criteria cr = getSession().createCriteria(Service.class);
        cr.add(Restrictions.and(
                Restrictions.eq("employee", employee),
                Restrictions.ge("startDate", dateFrom),
                Restrictions.le("endDate", dateTo)));

        return cr.list();
    }

    public List<Service> getByStatus(Status status) {
        Criteria cr = getSession().createCriteria(Service.class);
        cr.add(Restrictions.eq("status", status));

        return cr.list();
    }
}
