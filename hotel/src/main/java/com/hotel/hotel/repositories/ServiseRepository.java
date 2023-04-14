package com.hotel.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.models.Servise;

public interface ServiseRepository extends JpaRepository<Servise, Integer> {
    
}
