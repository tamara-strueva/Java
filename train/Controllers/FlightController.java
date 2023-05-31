package com.train.train.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.train.train.Models.Flight;
import com.train.train.Services.FlightService;

/**
 * Класс `FlightController` предоставляет конечные RESTful для взаимодействия с
 * объектами расписания рейсов
 */
@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    /**
     * Извлекает все объекты расписания из базы данных
     * 
     * @return список всех сущностей расписания в базе данных
     */
    @GetMapping("/get")
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    /**
     * Сохраняет один рейс в базу данных
     * 
     * @param flight - рейс для сохранения в базу данных
     */
    @PostMapping("/post")
    public void addFlight(@RequestBody Flight flight) {
        flightService.saveFlight(flight);
    }
}