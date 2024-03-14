package com.appointments.clcproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.appointments.clcproject.entity.RegisterUser;
import com.appointments.clcproject.service.UserService;

@Controller
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new RegisterUser());
        return "registration"; 
    }

    @PostMapping("/doRegistration")
    public String doRegistration(@ModelAttribute("user") RegisterUser user, BindingResult result) {

        if (result.hasErrors()) {
            // If there are form binding errors, re-render the registration form with errors.
            return "registration";
        }
        userService.registerUser(user); // Delegate user registration to UserService
        return "redirect:/login"; // Redirect to the login page to prevent form resubmission
    }
}