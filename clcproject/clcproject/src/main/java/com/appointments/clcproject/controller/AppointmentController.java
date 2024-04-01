package com.appointments.clcproject.controller;

import com.appointments.clcproject.entity.Appointment;
import com.appointments.clcproject.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/appointments")
    public String showAppointmentsPage() {
        return "appointments";
    }

    @PostMapping("/appointments")
    public String createAppointment(@RequestParam("appointmentDate") String date,
                                    @RequestParam("businessHours") String businessHours) {
        appointmentService.createAppointment(date, businessHours);
        return "redirect:/appointments"; // Redirects to the appointments page after creating an appointment
    }

    @GetMapping("/search")
    public String searchAppointments(@RequestParam(value = "appointmentDate", required = false) String appointmentDateStr, Model model) {
        List<Appointment> appointments;
    
        if (appointmentDateStr != null && !appointmentDateStr.isEmpty()) {
            // Search for appointments on the specified date
            appointments = appointmentService.findAppointmentsByDateString(appointmentDateStr);
        } else {
            // No date specified, return all appointments
            appointments = appointmentService.findAll();
        }
    
        model.addAttribute("appointments", appointments);
        return "search"; // Assumes you have a search.html Thymeleaf template for displaying the results
    }

    @GetMapping("/appointments/update/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Appointment appointment = appointmentService.findById(id); // Fetch the appointment
        model.addAttribute("appointment", appointment);
        return "update-appointment";
    }

    @PostMapping("/appointments/update/{id}")
    public String updateAppointment(@PathVariable Long id,
                                    @RequestParam("appointmentDate") String appointmentDate,
                                    @RequestParam("businessHours") String businessHours,
                                    @RequestParam("searchDate") String searchDate,
                                    RedirectAttributes redirectAttributes) {
        appointmentService.updateAppointment(id, appointmentDate, businessHours);
        redirectAttributes.addFlashAttribute("successMessage", "Appointment updated successfully.");
        return "redirect:/appointments"; // Redirect to the appointments page
    }

    // Method for showing delete confirmation
    @GetMapping("/appointments/confirm-delete/{id}")
    public String showDeleteConfirmation(@PathVariable("id") Long id, Model model) {
        Appointment appointment = appointmentService.findById(id);
        model.addAttribute("appointment", appointment);
        return "confirm-delete";
    }

    // Adjusted delete method
    @PostMapping("/appointments/delete/{id}")
    public String deleteAppointment(@PathVariable("id") Long id,
                                    @RequestParam(value = "searchDate", required = false) String searchDate,
                                    RedirectAttributes redirectAttributes) {
        try {
            appointmentService.delete(id);
            redirectAttributes.addFlashAttribute("successMessage", "Appointment deleted successfully.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error deleting appointment: " + e.getMessage());
        }
        if (searchDate != null) {
            return "redirect:/search?appointmentDate=" + searchDate;
        } else {
            return "redirect:/appointments";
        }
    }
}