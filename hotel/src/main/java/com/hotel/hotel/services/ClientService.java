package com.hotel.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.hotel.models.Client;
import com.hotel.hotel.repositories.ClientRepository;

import jakarta.transaction.Transactional;

@Service // кдасс является сервисом (бизнес-логика)
@Transactional // выполнится либо все, либо не выполнится вовсе
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    // получение списка всех клиентов
    public List<Client> getAllClients(){ 
        return clientRepository.findAll();
    }

    // получение списка клиентов по имени
    public List<Client> getClientByFirstName(String firstName){ 
        return clientRepository.findByFirstName(firstName);
    }

    // сохранение клиента
    public void saveClient(Client client){  
        clientRepository.save(client);
    }

    // удаление клиента
    public void deleteClient(Integer id){ 
        clientRepository.deleteById(id);
    }

    // получение клиента по id
    public Client getClientById(Integer id){ 
        return clientRepository.findById(id).get();
    }
}
