package com.instinctools.bordel.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Manager POJO. Represents person who manage workers
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Manager extends Person {
}
