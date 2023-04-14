package com.example.todo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    List<User> findByFirstName(String firstName);
}
