package com.appointments.clcproject.registration.model;

import java.time.LocalDate;

public class Appointment {
    private LocalDate appointmentDate;
    private int businessHours;

    // Constructor
    public Appointment(LocalDate appointmentDate, int businessHours) {
        this.appointmentDate = appointmentDate;
        this.businessHours = businessHours;
    }

    // Getters and Setters
    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public int getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(int businessHours) {
        this.businessHours = businessHours;
    }

    // ToString method for debugging
    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentDate=" + appointmentDate +
                ", businessHours=" + businessHours +
                '}';
    }
}
