package com.hotel.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.hotel.models.Room;
import com.hotel.hotel.repositories.RoomRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RoomServise {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public List<Room> getRoomByName(String name) {
        return roomRepository.findByName(name);
    }

    public Room getRoomById(Integer id) {
        return roomRepository.findById(id).get(); // get() ВАЖНООО 
    }

    public void deleteRoom(Integer id) {
        roomRepository.deleteById(id);
    }

    public void saveRoom(Room room) {
        roomRepository.save(room);
    }
    
}
