package com.appointments.clcproject.service;

import com.appointments.clcproject.entity.Appointment;
import com.appointments.clcproject.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    // Commite transaction updates and perform rollback on unsuccessful updates
    @Transactional
    public Appointment createAppointment(String date, String businessHours) {
        LocalDate appointmentDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        Appointment newAppointment = new Appointment(appointmentDate, businessHours);
        return appointmentRepository.save(newAppointment);
    }
}