package com.example.todo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.models.Task;
import com.example.todo.repositories.TaskRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    public void deleteTaskById(Integer id) {
        taskRepository.deleteById(id);
    }

    public Task getTaskById(Integer id) {
        return taskRepository.findById(id).get();
    }
    
}
