package com.instinctools.bordel.dao;

import com.instinctools.bordel.model.Employee;
import com.instinctools.bordel.model.Manager;
import com.instinctools.bordel.model.Office;
import com.instinctools.bordel.model.Sex;

import java.util.Calendar;
import java.util.List;

/**
 * Employee DAO interface.
 */
public interface EmployeeDao extends PersonDao<Employee> {

    /**
     * Finding employees depending on the tariff
     * @param min - start border of tariff
     * @param max - end border of tariff
     * @return List of employees who has tariff from min to max.
     */
    List<Employee> getByTariff(Integer min, Integer max);

    /**
     * Finding employees depending on the gender
     * @param sex filter value
     * @return List of employees with concrete sex
     */
    List<Employee> getBySex(final Sex sex);

    /**
     * Finding Employees by age.
     * @param from date of min birthday
     * @param to date of max birthday
     * @return List of Employees between from and to
     */
    List<Employee> getByAge(final Calendar from, final Calendar to);

    /**
     * Finding employees who has specialization
     * @param specialization for finding
     * @return List of founds Employees
     */
    List<Employee> getBySpecialization(final String specialization);

    /**
     * Finding employees by location
     * @param office where found employees
     * @return List of employees in office
     */
    List<Employee> getByOffice(final Office office);

    /**
     * Finding employees by manager
     * @param manager who manage employees
     * @return List of employees by manager
     */
    List<Employee> getByManager(final Manager manager);
}
