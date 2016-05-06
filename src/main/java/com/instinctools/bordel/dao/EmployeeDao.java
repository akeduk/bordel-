package com.instinctools.bordel.dao;

import com.instinctools.bordel.model.Employee;
import com.instinctools.bordel.model.Manager;
import com.instinctools.bordel.model.Office;
import com.instinctools.bordel.model.Sex;

import java.util.Calendar;
import java.util.List;

/**
 * Employee DAO interface.
 */
public interface EmployeeDao extends PersonDao<Employee> {

    /**
     * Finding employees by custom filter.
     *
     * @param filter - filter for fonding
     * @return List of employees
     */
    List<Employee> find(Filter filter);

    class Filter {
        private Float tariffMin;
        private Float tariffMax;
        private Sex sex;
        private Calendar birthdayFrom;
        private Calendar birthdayTo;
        private String specialization;
        private Office office;
        private Manager manager;

        public Float getTariffMin() {
            return tariffMin;
        }

        public void setTariffMin(final Float tariffMin) {
            this.tariffMin = tariffMin;
        }

        public Float getTariffMax() {
            return tariffMax;
        }

        public void setTariffMax(final Float tariffMax) {
            this.tariffMax = tariffMax;
        }

        public Sex getSex() {
            return sex;
        }

        public void setSex(Sex sex) {
            this.sex = sex;
        }

        public Calendar getBirthdayFrom() {
            return birthdayFrom;
        }

        public void setBirthdayFrom(final Calendar birthdayFrom) {
            this.birthdayFrom = birthdayFrom;
        }

        public Calendar getBirthdayTo() {
            return birthdayTo;
        }

        public void setBirthdayTo(final Calendar birthdayTo) {
            this.birthdayTo = birthdayTo;
        }

        public String getSpecialization() {
            return specialization;
        }

        public void setSpecialization(final String specialization) {
            this.specialization = specialization;
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
}
