package com.hotel.hotel.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="levels")
@Entity
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private Integer basePrice;

    public void updateLevel(Level level) {
        if (level.name != null) {
            this.name = level.name;
        }
        if (level.description != null) {
            this.description = level.description;
        }
        if (level.basePrice != null) {
            this.basePrice = level.basePrice;
        }
    }
    
}
