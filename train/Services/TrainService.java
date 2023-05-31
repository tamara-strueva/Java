package com.train.train.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.train.train.Models.Train;
import com.train.train.Repos.TrainRepo;

import jakarta.transaction.Transactional;

/**
 * Класс `TrainService` предоставляет методы взаимодействия с объектами
 * поездов, хранящимися в базе данных
 */
@Service
@Transactional
public class TrainService {

    @Autowired
    private TrainRepo trainRepo;

    /**
     * Сохраняет поезд в базу данных
     * 
     * @param train - поезд для сохранения в бвзу данных
     */
    public void saveTrain(Train train) {
        trainRepo.save(train);
    }

    /**
     * Извлекает все объекты поездов из базы данных
     * 
     * @return список всех поездов из базы данных
     */
    public List<Train> getAllTrains() {
        return trainRepo.findAll();
    }
}
