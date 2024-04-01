package com.appointments.clcprojectrest1.repository;


import java.time.LocalDate;
import java.util.List;

import com.appointments.clcprojectrest1.entity.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    List<Appointment> findByAppointmentDate(LocalDate appointmentDate);
}