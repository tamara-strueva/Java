package com.example.todo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.models.User;
import com.example.todo.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service // класс является сервисом (бизнес-логика)
@Transactional // выполняется либо полностью, либо не выполняется
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // получение списка всех пользователей из БД
    public List<User> getAllUsers() { //
        return userRepository.findAll();
    }

    // сохранение пользователя в БД
    public void saveUser(User user) { //
        userRepository.save(user);
    }

    // удаление пользователя из БД по id
    public void deleteUserById(Integer id) { // 
        userRepository.deleteById(id);
    }

    // получение 1 пользователя из БД по id
    public User getUserById(Integer id) { // 
        return userRepository.findById(id).get();
    }

    // получение списка пользователей из БД по имени
    public List<User> getUsersByFirstName(String fName) {
        return userRepository.findByFirstName(fName);
    }
    
}
