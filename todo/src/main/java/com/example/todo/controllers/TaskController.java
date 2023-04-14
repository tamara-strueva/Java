package com.example.todo.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.models.Task;
import com.example.todo.services.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/")
    public void save(@RequestBody Task task) { // @RequestBody чтоб не было null
        taskService.saveTask(task);
    }

    @GetMapping("")
    public List<Task> getAll() {
        return taskService.getAllTasks();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        taskService.deleteTaskById(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        try{
            Task task = taskService.getTaskById(id);
            return new ResponseEntity<Task>(task, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Task task, @PathVariable Integer id) {
        try{
            Task baseTask = taskService.getTaskById(id);
            baseTask.updateTask(task);
            taskService.saveTask(baseTask);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
