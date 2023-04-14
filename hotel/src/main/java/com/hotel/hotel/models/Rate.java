package com.hotel.hotel.models;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="rates")
@Entity
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // @JsonIgnore // его не следует считать «геттером», «установщиком» или «создателем»
    // @JoinColumn(name="room_id", nullable = false)
    private Room room;

    // @JoinColumn(name="level_id", nullable = false)
    private Level level;

    @ManyToMany
    @JoinColumn(name = "servise_id")
    private Set<Servise> servises;
    
}
