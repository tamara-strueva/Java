package com.train.train.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.train.train.Models.Flight;

/**
 * Интерфейс `FlightRepo` наследуется от `JpaRepository` и предоставляет
 * дополнительные методы взаимодействия с объектами расписания, хранящимися в
 * базе данных
 */
public interface FlightRepo extends JpaRepository<Flight, Long> {

}