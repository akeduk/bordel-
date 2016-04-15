package com.instinctools.bordel.dao.hibernate;

import com.instinctools.bordel.dao.ServiceDao;
import com.instinctools.bordel.model.Employee;
import com.instinctools.bordel.model.Service;
import com.instinctools.bordel.model.ServiceStatus;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.Calendar;
import java.util.List;

public class ServiceDaoHibernate extends AbstractDaoHibernate<Service, Long> implements ServiceDao {

    public ServiceDaoHibernate(Class<Service> persistentClass) {
        super(persistentClass);
    }

    public List<Service> getByEmployee(final Employee employee, final Calendar dateFrom, final Calendar dateTo) {
        Criteria cr = getSession().createCriteria(Service.class);
        cr.add(Restrictions.and(
                Restrictions.eq("employee", employee),
                Restrictions.ge("startDate", dateFrom),
                Restrictions.le("endDate", dateTo)));

        return cr.list();
    }

    public List<Service> getByStatus(final ServiceStatus status) {
        Criteria cr = getSession().createCriteria(Service.class);
        cr.add(Restrictions.eq("status", status));

        return cr.list();
    }
}
