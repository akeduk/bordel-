package com.instinctools.bordel.dao;

import com.instinctools.bordel.model.Employee;
import com.instinctools.bordel.model.Service;
import com.instinctools.bordel.model.Status;

import java.util.Calendar;
import java.util.List;

/**
 * Service DAO interface
 */
public interface ServiceDao extends GenericDao<Service, Long> {

    /**
     * Getting services of employee
     * @param employee which services need to found
     * @param dateFrom - start date of founding
     * @param dateTo - - start date of founding
     * @return List of found services
     */
    List getByEmployee(Employee employee, Calendar dateFrom, Calendar dateTo);

    /**
     * Getting services with specified status
     * @param status for filter
     * @return List of found services
     */
    List<Service> getByStatus(Status status);
}
