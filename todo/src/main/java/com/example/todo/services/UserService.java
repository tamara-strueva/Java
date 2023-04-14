package com.example.todo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.models.User;
import com.example.todo.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() { //
        return userRepository.findAll();
    }

    public void saveUser(User user) { //
        userRepository.save(user);
    }

    public void deleteUserById(Integer id) { // 
        userRepository.deleteById(id);
    }

    public User getUserById(Integer id) { // 
        return userRepository.findById(id).get();
    }

    public List<User> getUsersByFirstName(String fName) {
        return userRepository.findByFirstName(fName);
    }
    
}
