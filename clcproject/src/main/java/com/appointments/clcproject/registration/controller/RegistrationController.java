package com.appointments.clcproject.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.appointments.clcproject.registration.model.User;
import com.appointments.clcproject.registration.model.UserService;

@Controller
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration"; // Viewer for registration page
    }

    @PostMapping("/registration")
    public String submitRegistrationForm(User user) {
        userService.registerUser(user); // Delegate user registration to UserService
        return "registration"; // Redirect page function
    }
}