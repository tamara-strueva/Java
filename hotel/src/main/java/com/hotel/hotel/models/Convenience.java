package com.hotel.hotel.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="conveniences")
@Entity
public class Convenience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany // предполагает, что в обоих классах переменные будут коллекциями
    @JoinTable(name = "convenience_room",
        joinColumns = @JoinColumn(name = "convenience_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "room_id", referencedColumnName = "id"))
    private List<Room> rooms;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    public void updateConvenience(Convenience convenience) {
        if (convenience.name != null) {
            this.name = convenience.name;
        }
    }
}
