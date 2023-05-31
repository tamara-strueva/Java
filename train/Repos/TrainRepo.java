package com.train.train.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.train.train.Models.Train;

/**
 * Интерфейс `TrainRepo` наследуется от `JpaRepository` и предоставляет
 * дополнительные методы взаимодействия с объектами поездов, хранящимися в базе
 * данных
 */
public interface TrainRepo extends JpaRepository<Train, Long> {

}