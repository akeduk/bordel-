package com.instinctools.bordel.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Created by mack on 23.03.2016.
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Manager extends Person {
}
