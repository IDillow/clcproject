package com.appointments.clcproject.registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.appointments.clcproject.registration.model.Appointment;
import com.appointments.clcproject.registration.model.Valid;

@Controller
public class AppointmentsController {

    @GetMapping("/appointments")
    public String showAppointmentsPage(Model model) {
        model.addAttribute("appointment", new Appointment(null, 0));
        return "appointments";
    }

    @PostMapping("/createAppointment")
    public String createAppointment(@Valid @ModelAttribute("appointment") Appointment appointment,
                                    BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // Validation failure fallback and message
            return "appointments";
        }

        model.addAttribute("appointment", appointment);
        return "appointment_confirmation"; // Return a confirmation page
    }
}