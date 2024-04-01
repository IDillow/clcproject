package com.appointments.clcproject.repository;

import com.appointments.clcproject.entity.RegisterUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<RegisterUser, Long> {
    Optional<RegisterUser> findByUsername(String username);
}