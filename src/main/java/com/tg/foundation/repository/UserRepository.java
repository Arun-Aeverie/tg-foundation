package com.tg.foundation.repository;

import jakarta.persistence.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tg.foundation.model.User;

/**
 * The Repository Layer:
 * This interface bridges the gap between your Java code and the RDBMS (SQL).
 * Spring Data JPA will automatically generate the SQL queries (SELECT, INSERT, UPDATE, DELETE).
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // JpaRepository provides all standard CRUD operations out-of-the-box.
    // For example: findById(), findAll(), save(), and deleteById().
}
