package com.instinctools.bordel.dao;

import com.instinctools.bordel.model.Person;

import java.util.List;

/**
 * Person DAO interface
 */
public interface PersonDao<T extends Person> extends GenericDao<T, Long> {

    /**
     * Founding persons by name.
     * @param name which needs to found
     * @return List of found persons
     */
    List<T> getByName(final String name);
}
