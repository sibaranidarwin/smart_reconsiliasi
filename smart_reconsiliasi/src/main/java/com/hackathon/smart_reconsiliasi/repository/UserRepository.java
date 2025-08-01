package com.hackathon.smart_reconsiliasi.repository;

import com.hackathon.smart_reconsiliasi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

}
