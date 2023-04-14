package com.example.todo.models;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data // позволяет не писать конструктор, геттеры и сеттеры
@Table(name="users") // связь с таблицей БД
@Entity // сущность пользователя
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // генерирует id
    private int id;
    private String login;
    private String firstName; // имя
    private String middleName; // отчество
    private String lastName; // фамилия
    private Date birthDate;

    // связь с заданием
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Task> tasks; // как заполнять

    // метод для изменения 1 или нескольких атрибутов пользователя
    public void updateUser(User user) { // метод для редактироания или дополнения пользователя
        if (user.firstName != null) {
            this.firstName = user.firstName;
        }
        if (user.middleName != null) {
            this.middleName = user.middleName;
        }
        if (user.lastName != null) {
            this.lastName = user.lastName;
        }
        if (user.login != null) {
            this.login = user.login;
        }
        if (user.birthDate != null) {
            this.birthDate = user.birthDate;
        }
    }
}
