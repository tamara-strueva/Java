package com.train.train.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.train.train.Models.Train;
import com.train.train.Services.TrainService;

/**
 * Класс `TrainController` предоставляет конечные RESTful для взаимодействия с
 * объектами поездов
 */
@RestController
@RequestMapping("/trains")
public class TrainController {

    @Autowired
    private TrainService trainService;

    /**
     * Извлекает все объекты поездов из базы данных
     * 
     * @return список всех сущностей поездов в базе данных
     */
    @GetMapping("/get")
    public List<Train> getAllTrains() {
        return trainService.getAllTrains();
    }

    /**
     * Сохраняет один поезд в базу данных
     * 
     * @param train - поезд для сохранения в базу данных
     */
    @PostMapping("/post")
    public void addTrain(@RequestBody Train train) {
        trainService.saveTrain(train);
    }
}
