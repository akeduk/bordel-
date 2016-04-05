package com.instinctools.bordel.dao;

import com.instinctools.bordel.model.Employee;
import com.instinctools.bordel.model.Feedback;

import java.util.List;

/**
 * Feedback DAO interface
 */
public interface FeedbackDao extends GenericDao<Feedback, Long> {

    /**
     * Getting all feedback about employee services
     * @param employee which feedback need to find
     * @return List of feedback
     */
    List<Feedback> getByEmployee(Employee employee);
}
