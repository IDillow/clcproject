package com.appointments.clcproject.repository;

import com.appointments.clcproject.entity.RegisterUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<RegisterUser, Long> {
    RegisterUser findByUsername(String username);
}