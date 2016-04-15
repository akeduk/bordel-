package com.instinctools.bordel.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Calendar;

/**
 * Service POJO. Represents one meeting worker with client.
 */
@Entity
@Table(name = "service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar startDate;

    @NotBlank
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar endDate;

    @NotBlank
    @Column(name = "address")
    private String address;

    @NotBlank
    @Column(name = "cost")
    private Float cost;

    @NotNull
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ServiceStatus status;

    @OneToOne
    @JoinColumn(name = "feedback_id")
    private Feedback feedback;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(final Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(final Calendar endDate) {
        this.endDate = endDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(final Float cost) {
        this.cost = cost;
    }

    public ServiceStatus getStatus() {
        return status;
    }

    public void setStatus(final ServiceStatus status) {
        this.status = status;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(final Feedback feedback) {
        this.feedback = feedback;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(final Client client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(final Employee employee) {
        this.employee = employee;
    }
}
