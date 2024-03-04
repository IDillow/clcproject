package com.appointments.clcproject;

public class Appointment {

    @NotBlank(message = "Appointment date is required")
    @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "Invalid date format. Please use MM/DD/YYYY")
    private String appointmentDate;

    @NotBlank(message = "Business hours are required")
    @Pattern(regexp = "0[89]|1[0-7]", message = "Invalid business hours. Please select from 9:00 AM to 5:00 PM")
    private String businessHours;

    // Getters and setters
    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(String businessHours) {
        this.businessHours = businessHours;
    }
}
