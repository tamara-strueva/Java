package com.train.train.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Класс `Train` является сущностью поезда
 */
@Entity
@Table(name = "trains")
@Data
public class Train {

    /**
     * Уникальный идентификатор поезда
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Имя поезда
     */
    private String name;

    /**
     * Тип поезда
     */
    private String type;

    /**
     * Количество вагонов в поезде
     */
    private Integer numberOfVans;

    /**
     * Количество мест в каждом вагоне
     */
    private Integer numberOfSeats;

    /**
     * Связь поезда с расписанием
     */
    @JsonIgnore
    @OneToMany(mappedBy = "train")
    private List<Flight> flights;
}