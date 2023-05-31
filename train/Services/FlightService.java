package com.train.train.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.train.train.Models.Flight;
import com.train.train.Repos.FlightRepo;

import jakarta.transaction.Transactional;

/**
 * Класс `FlightService` предоставляет методы взаимодействия с объектами
 * расписания, хранящимися в базе данных
 */
@Service
@Transactional
public class FlightService {

    @Autowired
    private FlightRepo flightRepo;

    /**
     * Сохраняет один рейс в базу данных
     * 
     * @param flight - рейс для сохранения в базу данных
     */
    public void saveFlight(Flight flight) {
        flightRepo.save(flight);
    }

    /**
     * Извлекает все объекты расписания из базы данных
     * 
     * @return список всех сущностей расписания в базе данных
     */
    public List<Flight> getAllFlights() {
        return flightRepo.findAll();
    }
}