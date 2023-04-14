package com.hotel.hotel.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotel.models.Convenience;
import com.hotel.hotel.services.ConvenienceService;

@RestController
@RequestMapping("/conveniences")
public class ConvenienceController {
    @Autowired
    private ConvenienceService convenienceService;

    // добавить/сохранить
    @PostMapping("/")
    public void save(@RequestBody Convenience convenience) {
        convenienceService.saveConvenience(convenience);
    }

    // вывести все удобства
    @GetMapping("")
    public List<Convenience> getAllConveniences() {
        return convenienceService.getAllConvenieces();
    }

    // найти удобство по id и по имени
    @GetMapping("/{id}")
    public Convenience getById(@PathVariable Integer id) {
        return convenienceService.getConvenienceById(id);
    }

    @GetMapping("/name/{name}")
    public List<Convenience> getByName(@PathVariable String name) {
        return convenienceService.getConvenienceByName(name);
    }

    // удалить
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        convenienceService.deleteConvenience(id);
    }

    //изменить
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Convenience convenience, @PathVariable Integer id){
        try{
            Convenience baseConvenience = convenienceService.getConvenienceById(id);
            baseConvenience.updateConvenience(convenience);
            convenienceService.saveConvenience(baseConvenience);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
