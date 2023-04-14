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

import com.hotel.hotel.models.Level;
import com.hotel.hotel.services.LevelService;

@RestController
@RequestMapping("/levels")
public class LevelController {
    @Autowired
    private LevelService levelService;

    // вывести все комнаты
    @GetMapping("")
    public List<Level> getAllLevels() {
        return levelService.getAllLevels();
    }

    // добавить комнату
    @PostMapping("/")
    public void save(@RequestBody Level level) { // @RequestBody
        levelService.saveLevel(level);
    }

    // вывести информацию про определенную комнату по id/по номеру
    @GetMapping("/{id}")
    public ResponseEntity<Level> getById(@PathVariable Integer id) {
        try{
            Level level = levelService.getLevelById(id);
            return new ResponseEntity<Level>(level, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Level>(HttpStatus.NOT_FOUND);
        }
    }

    // @GetMapping("/name/{name}")
    // public List<Room> getRoomByName(@PathVariable String name) {
    //     return roomServise.getRoomByName(name);
    // }

    // // изменение описания
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Level level, @PathVariable Integer id) {
        try { // ResponseEntity<> 
            Level baseLevel = levelService.getLevelById(id);
            baseLevel.updateLevel(level);
            levelService.saveLevel(baseLevel);
            return new ResponseEntity<>(level, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // возвращение ошибки
        }
    }
}
