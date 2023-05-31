package com.train.train.Models;

import java.sql.Date;
import java.sql.Time;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Класс `Flight` является сущностью расписания
 */
@Entity
@Table(name = "flights")
@Data
public class Flight {

    /**
     * Уникальный идентификатор рейса
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Город отправления поезда
     */
    private String cityFrom;

    /**
     * Город прибытия поезда
     */
    private String cityTo;

    /**
     * Дата отправления поезда
     */
    private Date dateDeparture;

    /**
     * Время отправления поезда
     */
    private Time timeDeparture;

    /**
     * Дата прибытия поезда в пункт назначения
     */
    private Date dateArrival;

    /**
     * Время прибытия поезда в пункт назначения
     */
    private Time timeArrival;

    /**
     * Базовая цена на билет
     */
    private Float basePrice;

    /**
     * Связь с поездами, так как расписание должно принадлежать какому-либо поезду
     */
    @ManyToOne
    @JoinColumn(name = "trainId")
    private Train train;
}
