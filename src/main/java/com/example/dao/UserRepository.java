package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.User;

/**
 * User repository for CRUD operations.
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
