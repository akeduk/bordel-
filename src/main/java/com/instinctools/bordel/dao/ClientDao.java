package com.instinctools.bordel.dao;

import com.instinctools.bordel.model.Client;
import com.instinctools.bordel.dao.GenericDao;
import com.instinctools.bordel.model.Sex;

import java.util.Calendar;
import java.util.List;

/**
 * Client DAO interface.
 */
public interface ClientDao extends GenericDao<Client, Long> {

    /**
     * Finding clients with preferences.
     * @param preferences - string of preference
     * @return List of clients who has these preferences
     */
    List<Client> getByPreferences(String preferences);

    /**
     * Finding Clients by age.
     * @param from date of min birthday
     * @param to date of max birthday
     * @return List of clients between from and to
     */
    List<Client> getByBirthday(Calendar from, Calendar to);

}
