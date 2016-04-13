package com.instinctools.bordel.dao.hibernate;

import com.instinctools.bordel.dao.FeedbackDao;
import com.instinctools.bordel.model.Employee;
import com.instinctools.bordel.model.Feedback;

import java.util.List;

/**
 * Created by mack on 05.04.2016.
 */
public class FeedbackDaoHibernate extends AbstractDaoHibernate<Feedback, Long> implements FeedbackDao {

    public FeedbackDaoHibernate(Class<Feedback> persistentClass) {
        super(persistentClass);
    }

    public List<Feedback> getByEmployee(final Employee employee) {
        return null;
    }
}
