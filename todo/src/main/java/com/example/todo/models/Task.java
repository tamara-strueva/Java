package com.example.todo.models;

import java.sql.Date;
import java.util.Set;

// import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="tasks")
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private Date dateToDo;
    private Boolean completed;
 
    // пользователь
    @ManyToOne // у 1 пользователя может быть много заданий
    @JoinColumn(name = "user_id", nullable = false)
    private User user; 

    // категория
    @ManyToMany 
    @JoinColumn(name = "category_id")
    private Set<Category> categories; 

    public void updateTask(Task task) {
        if (task.name != null) {
            this.name = task.name;
        }
        if (task.description != null) {
            this.description = task.description;
        }
        if (task.dateToDo != null) {
            this.dateToDo = task.dateToDo;
        }
        if (task.completed != null) {
            this.completed = task.completed;
        }
    }
    
}
