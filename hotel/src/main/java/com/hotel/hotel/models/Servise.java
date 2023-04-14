package com.hotel.hotel.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="servises")
@Entity
public class Servise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Float additionPrice; 

    @ManyToMany
    @JoinTable(name = "servise_rates",
        joinColumns = @JoinColumn(name = "servise_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "rate_id", referencedColumnName = "id"))
    private List<Rate> rates;
    
}
