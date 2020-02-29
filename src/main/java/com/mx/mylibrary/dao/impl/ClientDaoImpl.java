package com.mx.mylibrary.dao.impl;

import com.mx.mylibrary.dao.ClientDao;
import com.mx.mylibrary.entity.Client;
import com.mx.mylibrary.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("clientDao")
public class ClientDaoImpl implements ClientDao {

    @Autowired
    @Qualifier("clientRepository")
    private ClientRepository clientRepository;

    @Override
    public List<Client> listAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public boolean delete(int id) {
        return clientRepository.findById(new Integer(id)).map(item -> {
            item.setStatus(false);
            clientRepository.save(item);
            return true;
        }).orElse(false);
    }
}
