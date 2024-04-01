package com.appointments.clcproject.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table("appointments")
public class Appointment {
    @Id
    @Column("appointmentID")
    private Long appointmentID; 

    @Column("appointmentDate")
    private LocalDate appointmentDate;

    @Column("businessHours")
    private String businessHours;

    // Constructors, Getters and Setters
    public Appointment(LocalDate appointmentDate, String businessHours) {
        this.appointmentDate = appointmentDate;
        this.businessHours = businessHours;
    }

    public Long getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(Long appointmentID) {
        this.appointmentID = appointmentID;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(String businessHours) {
        this.businessHours = businessHours;
    }

    // ToString method
    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + appointmentID +
                ", appointmentDate=" + appointmentDate +
                ", businessHours=" + businessHours +
                '}';
    }
}