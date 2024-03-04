package com.appointments.clcproject.registration.model;

public interface UserService {
    boolean authenticateUser(User user);

    void registerUser(User user);
}
