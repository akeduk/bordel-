package com.instinctools.bordel.model;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by mack on 23.03.2016.
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Employee  extends Person{

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "tariff")
    private Integer tariff;

    @Column(name = "sex")
    @Enumerated
    private Sex sex;

    @Column(name = "birthday")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar birthday;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "office_id", insertable = false, updatable = false)
    private Office office;

    @ManyToOne
    @JoinColumn(name = "manager_id", insertable = false, updatable = false)
    private Manager manager;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getTariff() {
        return tariff;
    }

    public void setTariff(Integer tariff) {
        this.tariff = tariff;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
