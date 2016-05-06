package com.instinctools.bordel.services;

import com.instinctools.bordel.dao.EmployeeDao;
import com.instinctools.bordel.dao.hibernate.EmployeeDaoHibernate;
import com.instinctools.bordel.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Represent service class for employee.
 * CRUD operations and another logic
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeDaoHibernate employeeDaoHibernate;

    public List<Employee> findbyTariff(final Float min, final Float max) {
        EmployeeDao.Filter filter = new EmployeeDao.Filter();
        filter.setTariffMin(min);
        filter.setTariffMax(max);

        return employeeDaoHibernate.find(filter);
    }

    public Employee get(final Long id){

        return employeeDaoHibernate.get(id);
    }

    public List<Employee> getAll(){

        return employeeDaoHibernate.getAll();
    }

    public Employee save(final Employee employee) {

        return employeeDaoHibernate.save(employee);
    }

    public Employee remove(Long id) {
        Employee employee = employeeDaoHibernate.get(id);

        if (employee != null) {
            employeeDaoHibernate.remove(employee);
        }

        return employee;
    }
}
