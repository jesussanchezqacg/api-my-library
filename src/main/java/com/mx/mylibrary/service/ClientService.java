package com.mx.mylibrary.service;

import com.mx.mylibrary.dao.ClientDao;
import com.mx.mylibrary.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional(readOnly = true)
@Service("clientService")
public class ClientService {

    @Autowired
    @Qualifier("clientDao")
    private ClientDao clientDao;

    public List<Client> listAll() {
        return clientDao.listAll();
    }

    @Transactional
    public Client save(Client client) {
        return clientDao.save(client);
    }

    @Transactional
    public Client update(Client client) {
        return clientDao.update(client);
    }

    @Transactional
    public boolean delete(int id) {
        return clientDao.delete(id);
    }
}
