package com.appointments.clcproject.controller;

import com.appointments.clcproject.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/appointments")
    public String showAppointmentsPage() {
        // Code to retrieve and display appointments, or redirect to appropriate page
        return "appointments";
    }

    @PostMapping("/appointments")
    public String createAppointment(@RequestParam("appointmentDate") String date,
                                    @RequestParam("businessHours") String businessHours) {
        appointmentService.createAppointment(date, businessHours);
        return "redirect:/appointments"; // Redirects to the appointments page after creating an appointment
    }
}