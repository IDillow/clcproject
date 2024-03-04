package com.appointments.clcproject.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.appointments.clcproject.registration.model.User;
import com.appointments.clcproject.registration.model.UserService;

@Controller
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String showLoginForm(Model model, @RequestParam(required = false) String error) {
        model.addAttribute("user", new User());
        if (error != null) {
            model.addAttribute("error", "Incorrect login information");
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, Model model) {
        // Perform authentication logic using the UserService
        // For demonstration purposes, always return true to allow all login attempts
        if (userService.authenticateUser(user)) {
            return "redirect:/appointments"; // Redirect to the main appointments page upon successful login
        } else {
            model.addAttribute("error", "Incorrect login information");
            return "login"; // Return to the login page with an error message
        }
    }
}