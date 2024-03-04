package com.appointments.clcproject;

public interface UserService {
    boolean authenticateUser(User user);

    void registerUser(User user);
}
