package com.instinctools.bordel.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Generic Data Access Object with CRUD methods
 */
public interface GenericDao<T, PK extends Serializable> {

    /**
     * Generic method to get all object.
     *
     * @return List of parameter object
     */
    List<T> getAll();

    /**
     * Generic method to get object by id.
     * @param id identifiers of the object
     * @return found object
     */
    T get(PK id);

    /**
     * Generic method to save an object. Update or insert
     * @param object to save
     * @return saved object
     */
    T save(T object);

    /**
     * Generic method to delete an object
     * @param object to remove
     */
    void remove(T object);

}
