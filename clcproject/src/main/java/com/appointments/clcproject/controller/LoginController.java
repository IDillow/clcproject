package com.appointments.clcproject.controller;

import com.appointments.clcproject.entity.RegisterUser;
import com.appointments.clcproject.model.Login;
import com.appointments.clcproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class LoginController {

    private final UserRepository userRepository;

    @Autowired
    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("title", "Login Form");
        model.addAttribute("login", new Login());
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@Valid @ModelAttribute("login") Login loginModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Login Form");
            return "login";
        }

        // Retrieve user by username from the repository
        RegisterUser user = userRepository.findByUsername(loginModel.getUsername());

        // Check if user exists and if the password matches
        if (user != null && user.getPassword().equals(loginModel.getPassword())) {
            // Authentication successful
            return "redirect:/appointments"; // Redirect to the main appointments page
        } else {
            // Authentication failed
            model.addAttribute("error", "Incorrect username or password");
            return "login";
        }
    }
}