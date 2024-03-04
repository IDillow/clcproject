package com.appointments.clcproject.registration.model;

// Login information storage fields
public class Login {
    private String username;
    private String password;
    private boolean loggedIn;

    // Constructors
    public Login() {
    }

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
        this.loggedIn = false;
    }

    // Getters and setters
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