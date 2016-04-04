package com.instinctools.bordel.dao.hibernate;

import com.instinctools.bordel.model.Client;
import com.instinctools.bordel.dao.GenericDao;

import java.util.List;

/**
 * Created by mack on 04.04.2016.
 */
public interface ClientDao extends GenericDao<Client, Long> {

    List<Client> getByPreferences(String preferences);
}
