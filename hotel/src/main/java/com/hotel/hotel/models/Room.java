package com.hotel.hotel.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Integer floor;
    private String description;

    @ManyToMany
    @JoinColumn(name="convenience_id")
    private List<Convenience> conveniences;
    
    
    // для изменения 1 из атрибутов
    public void updateRoom(Room room) {
        if (room.name != null) {
            this.name = room.name;
        }
        // этаж не меняется
        if (room.floor != null) {
            this.floor = room.floor;
        }
        if (room.description != null) {
            this.description = room.description;
        }
    }
}
