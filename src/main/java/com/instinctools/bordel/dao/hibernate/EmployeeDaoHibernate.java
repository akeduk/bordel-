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

//    public EmployeeDaoHibernate(Class<Employee> persistentClass) {
//        super(persistentClass);
//    }

    public List<Employee> getByTariff(final Float min, final Float max) {
        Criteria cr = getSession().createCriteria(Employee.class);
        cr.add(Restrictions.between("tariff", min, max));

        return cr.list();
    }

    public List<Employee> getBySex(final Sex sex) {
        Criteria cr = getSession().createCriteria(Employee.class);
        cr.add(Restrictions.eq("sex", sex));

        return cr.list();
    }

    public List<Employee> getByAge(final Calendar from, final Calendar to) {
        Criteria cr = getSession().createCriteria(Employee.class);
        cr.add(Restrictions.between("birthday", from, to));

        return cr.list();
    }

    public List<Employee> getBySpecialization(final String specialization) {
        Criteria cr = getSession().createCriteria(Employee.class);
        cr.add(Restrictions.like("specialization", specialization, MatchMode.ANYWHERE));

        return cr.list();
    }

    public List<Employee> getByOffice(final Office office) {
        Criteria cr = getSession().createCriteria(Employee.class);
        cr.add(Restrictions.eq("office", office));

        return cr.list();
    }

    public List<Employee> getByManager(final Manager manager) {
        Criteria cr = getSession().createCriteria(Employee.class);
        cr.add(Restrictions.eq("manager", manager));

        return cr.list();
    }
}
