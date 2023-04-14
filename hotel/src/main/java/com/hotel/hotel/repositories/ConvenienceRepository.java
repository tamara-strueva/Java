package com.hotel.hotel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.models.Convenience;

public interface ConvenienceRepository extends JpaRepository<Convenience, Integer>{
    List<Convenience> findByName(String name);
}
