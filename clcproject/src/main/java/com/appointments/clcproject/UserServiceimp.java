package com.appointments.clcproject;

import org.springframework.stereotype.Service;

//UserService to be injected into LoginController and used for authentication
@Service
public class UserServiceimp implements UserService {
    @Override
    public boolean authenticateUser(User user) {
        // Emulate authentication logic
        if ("admin".equals(user.getUsername()) && "password".equals(user.getPassword())) {
            return true;
        }
        return false;
    }

    @Override
    public void registerUser(User user) {
        throw new UnsupportedOperationException("Unimplemented method 'registerUser'");
    }
}
