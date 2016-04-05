package com.instinctools.bordel.dao.hibernate;

import com.instinctools.bordel.dao.EmployeeDao;
import com.instinctools.bordel.model.Employee;
import com.instinctools.bordel.model.Manager;
import com.instinctools.bordel.model.Office;
import com.instinctools.bordel.model.Sex;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import java.util.Calendar;
import java.util.List;

/**
 * Created by mack on 04.04.2016.
 */
public class EmployeeDaoHibernate extends PersonDaoHibernate<Employee> implements EmployeeDao {

    public EmployeeDaoHibernate(Class<Employee> persistentClass) {
        super(persistentClass);
    }

    public List<Employee> getByTariff(Integer min, Integer max) {
        Criteria cr = getSession().createCriteria(Employee.class);
        cr.add(Restrictions.between("tariff", min, max));

        return cr.list();
    }

    public List<Employee> getBySex(Sex sex) {
        Criteria cr = getSession().createCriteria(Employee.class);
        cr.add(Restrictions.eq("sex", sex));

        return cr.list();
    }

    public List<Employee> getByAge(Calendar from, Calendar to) {
        Criteria cr = getSession().createCriteria(Employee.class);
        cr.add(Restrictions.between("birthday", from, to));

        return cr.list();
    }

    public List<Employee> getBySpecialization(String specialization) {
        Criteria cr = getSession().createCriteria(Employee.class);
        cr.add(Restrictions.like("specialization", specialization, MatchMode.ANYWHERE));

        return cr.list();
    }

    public List<Employee> getByOffice(Office office) {
        Criteria cr = getSession().createCriteria(Employee.class);
        cr.add(Restrictions.eq("office", office));

        return cr.list();
    }

    public List<Employee> getByManager(Manager manager) {
        Criteria cr = getSession().createCriteria(Employee.class);
        cr.add(Restrictions.eq("manager", manager));

        return cr.list();
    }
}
