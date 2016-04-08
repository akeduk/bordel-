package com.instinctools.bordel.model;

import javax.persistence.*;
import java.util.Calendar;

/**
 *  Client of service POJO
 */
@Entity
@Table(name = "client")
@PrimaryKeyJoinColumn(name = "id")
public class Client extends Person {

    @Column(name = "birthday")
    @Temporal(TemporalType.TIMESTAMP)
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

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
