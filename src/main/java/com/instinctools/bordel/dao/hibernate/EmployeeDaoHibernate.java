package com.instinctools.bordel.dao.hibernate;

import com.instinctools.bordel.dao.EmployeeDao;
import com.instinctools.bordel.model.Employee;
import com.instinctools.bordel.model.Manager;
import com.instinctools.bordel.model.Office;
import com.instinctools.bordel.model.Sex;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;

@Repository
public class EmployeeDaoHibernate extends PersonDaoHibernate<Employee> implements EmployeeDao {

    public EmployeeDaoHibernate() {
        super(Employee.class);
    }

    @Override
    public List<Employee> find(Filter filter) {
        Criteria cr = getSession().createCriteria(Employee.class);

        if (filter.getTariffMin() != null) {
            cr.add(Restrictions.ge("tariff", filter.getTariffMin()));
        }

        if (filter.getTariffMax() != null) {
            cr.add(Restrictions.le("tariff", filter.getTariffMax()));
        }

        if (filter.getSex() != null) {
            cr.add(Restrictions.eq("sex", filter.getSex()));
        }

        if (filter.getBirthdayFrom() != null) {
            cr.add(Restrictions.ge("birthday", filter.getBirthdayFrom()));
        }

        if (filter.getBirthdayTo() != null) {
            cr.add(Restrictions.le("birthday", filter.getBirthdayTo()));
        }

        if (filter.getSpecialization() != null) {
            cr.add(Restrictions.like("specialization", filter.getSpecialization(), MatchMode.ANYWHERE));
        }

        if (filter.getOffice() != null) {
            cr.add(Restrictions.eq("office", filter.getOffice()));
        }

        if (filter.getManager() !=null) {
            cr.add(Restrictions.eq("manager", filter.getManager()));
        }

        return cr.list();
    }
}
