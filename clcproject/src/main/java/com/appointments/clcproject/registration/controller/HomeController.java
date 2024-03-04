package com.appointments.clcproject.registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Calendar;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        // Dynamic login message based on time of the day, cannot get to display in theme
        String loginMessage;
        int currentTime = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (currentTime >= 5 && currentTime < 12) {
            loginMessage = "Good morning!";
        } else if (currentTime >= 12 && currentTime < 18) {
            loginMessage = "Good afternoon!";
        } else {
            loginMessage = "Good evening!";
        }
        model.addAttribute("loginMessage", loginMessage);
        return "home";
    }
}