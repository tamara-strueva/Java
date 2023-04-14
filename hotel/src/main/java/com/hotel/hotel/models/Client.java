package com.hotel.hotel.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity // сущность клиента
@Table(name="clients") // связь с таблицей в БД
@Data // позволяет не прописывать конструктор, геттеры и сеттеры
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // генерация id
    private int id;
    private String firstName;
    private String lastName;
    private String middleName;

    // связь с заказами
    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private Set<Order> orders;

    // метод для редактирование 1 или нескольких атрибутов клиента
    public void updateClient(Client client){
        if(client.firstName != null){
            this.firstName = client.firstName;
        }
        if(client.lastName != null){
            this.lastName = client.lastName;
        }
        if(client.middleName != null){
            this.middleName = client.middleName;
        }
    }
}
