package com.instinctools.bordel.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Generic Data Access Object with CRUD methods
 */
public interface GenericDao<T, PK extends Serializable> {

    List<T> getAll();

    T get(PK id);

    T save(T object);

    void remove(T object);

}
