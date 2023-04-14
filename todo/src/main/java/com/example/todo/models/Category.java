package com.example.todo.models;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="categories")
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    // @OneToMany(mappedBy = "category_id")
    // private List<Task> tasks;
    @ManyToMany
    @JoinTable(name = "category_task", // таблица связи 
        joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"), // колонка id категории в таблице category_task будет называться category_id
        inverseJoinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id")) // аналогично для задания
    private Set<Task> tasks;
}
