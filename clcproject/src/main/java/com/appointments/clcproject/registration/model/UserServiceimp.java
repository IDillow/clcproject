package com.appointments.clcproject.registration.model;

import org.springframework.stereotype.Service;

// UserService to be injected into LoginController and used for authentication
@Service
public class UserServiceimp implements UserService {

    @Override
    public boolean authenticateUser(User user) {
        // Always return true for authentication
        return true;
    }

    @Override
    public void registerUser(User user) {
        throw new UnsupportedOperationException("Unimplemented method 'registerUser'");
    }
}
