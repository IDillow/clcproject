package com.appointments.clcprojectrest1.service;

import com.appointments.clcprojectrest1.entity.Appointment;
import com.appointments.clcprojectrest1.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Transactional
    public Appointment createAppointment(String date, String businessHours) {
        LocalDate appointmentDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        Appointment newAppointment = new Appointment(appointmentDate, businessHours); // Assume your Appointment entity accepts these parameters
        return appointmentRepository.save(newAppointment);
    }

    @Transactional
    public List<Appointment> findAppointmentsByDateString(String appointmentDateStr) {
        LocalDate appointmentDate = LocalDate.parse(appointmentDateStr, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        return appointmentRepository.findByAppointmentDate(appointmentDate);
    }

    @Transactional
    public Appointment updateAppointment(Long id, String newDate, String newBusinessHours) {
        Appointment appointmentToUpdate = appointmentRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid appointment Id:" + id));

        LocalDate parsedDate = LocalDate.parse(newDate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        appointmentToUpdate.setAppointmentDate(parsedDate);
        appointmentToUpdate.setBusinessHours(newBusinessHours);
        return appointmentRepository.save(appointmentToUpdate);
    }

    @Transactional(readOnly = true)
    public Appointment findById(Long id) {
        return appointmentRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("Invalid appointment Id:" + id));
    }

    @Transactional
    public void delete(Long id) {
        appointmentRepository.deleteById(id);
    }
}