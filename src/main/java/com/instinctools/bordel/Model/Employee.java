package com.instinctools.bordel.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.util.Calendar;

/**
 * Employee POJO. Represents worker of Bordel
 */
@Entity
@Table(name = "employee")
@PrimaryKeyJoinColumn(name = "id")
public class Employee  extends Person{

    @Length(min = 1, max = 255)
    @Column(name = "nickname")
    private String nickname;

    @NotNull
    @Digits(integer = 10 ,fraction = 0)
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
    @JoinColumn(name = "office_id")
    private Office office;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(final String nickname) {
        this.nickname = nickname;
    }

    public Integer getTariff() {
        return tariff;
    }

    public void setTariff(final Integer tariff) {
        this.tariff = tariff;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(final Sex sex) {
        this.sex = sex;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(final Calendar birthday) {
        this.birthday = birthday;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(final String specialization) {
        this.specialization = specialization;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(final Office office) {
        this.office = office;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(final Manager manager) {
        this.manager = manager;
    }
}
