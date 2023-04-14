package com.hotel.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.hotel.models.Servise;
import com.hotel.hotel.repositories.ServiseRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServiseService {
    // getAll...
    // save...
    // delite...
    // getById
    @Autowired
    private ServiseRepository serviseRepository;

    public List<Servise> getAllServices() {
        return serviseRepository.findAll();
    }

    public void saveServise(Servise servise) {
        serviseRepository.save(servise);
    }

    public void deleteServise(Integer id) {
        serviseRepository.deleteById(id);
    }

    public Servise getServiseById(Integer id) {
        return serviseRepository.findById(id).get();
    }
    
}
