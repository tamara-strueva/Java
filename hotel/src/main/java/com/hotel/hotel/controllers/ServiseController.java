package com.hotel.hotel.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotel.models.Servise;
import com.hotel.hotel.services.ServiseService;

@RestController
@RequestMapping("/services")
public class ServiseController {
    @Autowired
    private ServiseService serviseService;

    // вывести все услуги
    @GetMapping("")
    public List<Servise> getAllRooms() {
        return serviseService.getAllServices();
    }

    // добавить услугу
    @PostMapping("/")
    public void save(@RequestBody Servise servise) { // @RequestBody
        serviseService.saveServise(servise);
    }

    // вывести информацию про определенную услугу по id/по номеру
    @GetMapping("/{id}")
    public ResponseEntity<Servise> getById(@PathVariable Integer id) {
        try{
            Servise servise = serviseService.getServiseById(id);
            return new ResponseEntity<>(servise, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Servise>(HttpStatus.NOT_FOUND);
        }
    }

    // @GetMapping("/name/{name}")
    // public List<Servise> getRoomByName(@PathVariable String name) {
    //     return 
    // }

    // изменение описания
    // @PutMapping("/{id}")
    // public ResponseEntity<?> update(@RequestBody Room room, @PathVariable Integer id) {
    //     try { // ResponseEntity<> 
    //         Room baseRoom = roomServise.getRoomById(id); // получение комнаты для изменения данных
    //         baseRoom.updateRoom(room); // изменение параметров
    //         roomServise.saveRoom(baseRoom); // сохранение изменений
    //         return new ResponseEntity<>(HttpStatus.OK); // 
    //     }catch (NoSuchElementException e) {
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND); // возвращение ошибки
    //     }
    // }
    
}
