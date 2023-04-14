package com.hotel.hotel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.models.Room;

public interface RoomRepository extends JpaRepository<Room, Integer>{
    List<Room> findByName(String name);
    
}
