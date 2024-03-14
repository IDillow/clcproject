package com.appointments.clcproject.service;

import com.appointments.clcproject.entity.RegisterUser;
import com.appointments.clcproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Commite transaction updates and perform rollback on unsuccessful updates
    @Transactional
    public void registerUser(RegisterUser user) {
        userRepository.save(user);
    }


}
