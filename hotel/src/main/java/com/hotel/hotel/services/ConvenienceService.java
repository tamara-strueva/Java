package com.hotel.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.hotel.models.Convenience;
import com.hotel.hotel.repositories.ConvenienceRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ConvenienceService {
    @Autowired
    private ConvenienceRepository convenienceRepository;

    public List<Convenience> getAllConvenieces() {
        return convenienceRepository.findAll(); 
    }

    public Convenience getConvenienceById(Integer id) {
        return convenienceRepository.findById(id).get();
    }

    public List<Convenience> getConvenienceByName(String name) {
        return convenienceRepository.findByName(name);
    }

    public void saveConvenience(Convenience convenience) {
        convenienceRepository.save(convenience);
    }

    public void deleteConvenience(Integer id) {
        convenienceRepository.deleteById(id);
    }
}
