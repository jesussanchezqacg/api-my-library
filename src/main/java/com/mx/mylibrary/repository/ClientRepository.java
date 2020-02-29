package com.mx.mylibrary.repository;

import com.mx.mylibrary.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("clientRepository")
public interface ClientRepository extends JpaRepository<Client, Serializable> {

}
