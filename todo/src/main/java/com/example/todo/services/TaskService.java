package com.example.todo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.models.Task;
import com.example.todo.repositories.TaskRepository;

import jakarta.transaction.Transactional;

@Service // класс является сервисом (бизнес-логика)
@Transactional // выполняется либо полностью, либо не выполняется
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    // получение списка всех заданий из БД
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // сохранение задания в БД
    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    // удаление задания из БД по id
    public void deleteTaskById(Integer id) {
        taskRepository.deleteById(id);
    }

    // получение 1 задания из БД по id
    public Task getTaskById(Integer id) {
        return taskRepository.findById(id).get();
    }
    
}
