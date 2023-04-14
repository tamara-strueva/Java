package com.hotel.hotel.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotel.models.Room;
import com.hotel.hotel.services.RoomServise;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomServise roomServise;

    // вывести все комнаты
    @GetMapping("")
    public List<Room> getAllRooms() {
        return roomServise.getAllRooms();
    }

    // добавить комнату
    @PostMapping("/")
    public void save(@RequestBody Room room) { // @RequestBody
        roomServise.saveRoom(room);
    }

    // вывести информацию про определенную комнату по id/по номеру
    @GetMapping("/{id}")
    public ResponseEntity<Room> getById(@PathVariable Integer id) {
        try{
            Room room = roomServise.getRoomById(id);
            return new ResponseEntity<Room>(room, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Room>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/name/{name}")
    public List<Room> getRoomByName(@PathVariable String name) {
        return roomServise.getRoomByName(name);
    }

    // изменение описания
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Room room, @PathVariable Integer id) {
        try { // ResponseEntity<> 
            Room baseRoom = roomServise.getRoomById(id); // получение комнаты для изменения данных
            baseRoom.updateRoom(room); // изменение параметров
            roomServise.saveRoom(baseRoom); // сохранение изменений
            return new ResponseEntity<>(HttpStatus.OK); // 
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // возвращение ошибки
        }
    }
    
}
