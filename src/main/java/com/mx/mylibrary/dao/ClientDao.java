package com.mx.mylibrary.dao;

import com.mx.mylibrary.entity.Client;

import java.util.List;

public interface ClientDao {

    List<Client> listAll();
    Client save(Client client);
    Client update(Client client);
    boolean delete(int id);
}
