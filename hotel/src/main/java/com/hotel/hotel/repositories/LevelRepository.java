package com.hotel.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.models.Level;

public interface LevelRepository extends JpaRepository<Level, Integer> {
    
}
