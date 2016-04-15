package com.instinctools.bordel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Calendar;

/**
 *  Client of service POJO
 */
@Entity
@Table(name = "client")
@PrimaryKeyJoinColumn(name = "id")
public class Client extends Person {

    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Calendar birthday;

    @Column(name = "sex")
    @Enumerated
    private Sex sex;

    @Column(name = "preferences")
    private String preferences;

    @Column(name = "description")
    private String description;

    public Client() {
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(final Calendar birthday) {
        this.birthday = birthday;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(final Sex sex) {
        this.sex = sex;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(final String preferences) {
        this.preferences = preferences;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }
}
