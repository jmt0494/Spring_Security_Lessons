package com.example.ss_2022_c2_1.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ss_2022_c2_1.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    
    @Query("""
            SELECT u FROM User u WHERE u.username = :username
            """)
    Optional<User> findUserByUsername(String username);
}
