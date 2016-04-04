package com.instinctools.bordel.dao.hibernate;

import com.instinctools.bordel.model.Employee;

/**
 * Created by mack on 04.04.2016.
 */
public class EmployeeDaoHibernate extends AbstractDaoHibernate<Employee, Long> {

    public EmployeeDaoHibernate(Class<Employee> persistentClass) {
        super(persistentClass);
    }
}
