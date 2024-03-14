package com.appointments.clcproject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Table("login") // Database table
public class Login {

    @Id
    @NotNull(message = "Username cannot be null")
    @Size(max = 24, message = "Username must be less than 25 characters")
    private String username;

    @NotNull(message = "Password cannot be null")
    @Size(max = 24, message = "Password must be less than 25 characters")
    private String password;

    private boolean loggedIn;

    // Constructors, Getters and Setters
    public Login() {
    }

    public Login(String username, String password, boolean loggedIn) {
        this.username = username;
        this.password = password;
        this.loggedIn = loggedIn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}