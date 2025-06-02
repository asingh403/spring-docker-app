package com.sdet.demo.repository;

import com.sdet.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Find user by email
    Optional<User> findByEmail(String email);
    
    // Find users by department
    List<User> findByDepartment(String department);
    
    // Check if email exists
    boolean existsByEmail(String email);
}
